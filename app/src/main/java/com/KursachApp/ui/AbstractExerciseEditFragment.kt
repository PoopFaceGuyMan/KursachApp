package com.KursachApp.ui

import java.lang.Exception
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator
import com.KursachApp.R
import com.KursachApp.databinding.FragmentExerciseEditBinding
import com.KursachApp.databinding.SetBinding
import com.KursachApp.util.Extensions.Companion.toEmptyString
import com.KursachApp.model.Set
import com.KursachApp.model.ExerciseWithSets

abstract class AbstractExerciseEditFragment: Fragment() {

    interface Callbacks {
        fun onFinished()
    }

    protected open val TAG = "AbstractExerciseEditFragment"

    protected abstract val vm: AbstractExerciseEditViewModel

    protected val adapter = SetAdapter()

    protected val removedItems: MutableList<Set> = mutableListOf()

    protected val binding get() = _binding!!

    protected var _binding: FragmentExerciseEditBinding? = null

    protected var hashCode: Int? = null

    protected var callbacks: Callbacks? = null

    protected lateinit var exercise: ExerciseWithSets

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callbacks = context as Callbacks
        } catch (ex: Exception) {
            throw IllegalStateException(
                "Hosting activity needs to implement Callbacks interface"
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_exercise_edit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_set -> {
                dataSetAdd()
                true
            } else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExerciseEditBinding
            .inflate(layoutInflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = FadeInRightAnimator().apply {
            addDuration = 250
            removeDuration = 250
        }
        vm.exerciseLiveData.observe(
            viewLifecycleOwner,
            { exercise ->
                exercise?.let { it ->
                    Log.i(TAG, "Got exercise: ${it.exercise.id}")
                    this.exercise = it
                    this.hashCode = it.hashCode()
                    updateUI()
                }
            }
        )
        binding.name.doOnTextChanged { text, _, _, _ ->
            if (!TextUtils.isEmpty(text)) {
                exercise.exercise.name = text.toString()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    /**
     * Binds an instance of [ExerciseWithSets] to the UI.
     */
    protected open fun updateUI() {
        binding.name
            .setText(exercise.exercise.name, TextView.BufferType.EDITABLE)
        adapter.submitList(exercise.sets)
    }

    /**
     * Adds a new item to the tail end of the underlying data-set.
     * The adapter will thereafter be notified of an inserted item.
     */
    protected fun dataSetAdd() {
        exercise.sets.add(
            Set.newInstance(exercise = exercise.exercise.id))
        adapter.notifyItemInserted(adapter.itemCount)
    }

    /**
     * Removes the item positioned at [index] from the underlying
     * data-set, and adds it to [removedItems].
     * The adapter will thereafter be notified of a removed item at position index.
     * @param index the index of the to-be removed item.
     */
    protected fun dataSetRemove(index: Int) {
        val item = exercise.sets.removeAt(index)
        removedItems.add(item)
        adapter.notifyItemRemoved(index)
    }

    /**
     * Inserts the specified [item] at position [index] in the underlying data-set, and
     * removes it from [removedItems].
     * The adapter will thereafter be notified of an inserted item at position index.
     * @param index the index of the to-be inserted item.
     * @param item the set to be inserted.
     */
    protected fun dataSetInsert(index: Int, item: Set) {
        removedItems.remove(item)
        exercise.sets.add(index, item)
        adapter.notifyItemInserted(index)
    }

    protected inner class SetHolder(private val binding: SetBinding):
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var set: Set

        init {
            binding.repsLayout.setEndIconOnClickListener { removeSet() }
            binding.weights.doOnTextChanged { text, _, _, _ ->
                if (!TextUtils.isEmpty(text)) {
                    set.weights = text.toString().toDouble()
                }
            }
            binding.reps.doOnTextChanged { text, _, _, _ ->
                if (!TextUtils.isEmpty(text)) {
                    set.reps = text.toString().toInt()
                }
            }
        }

        /**
         * Bind the specified [set] to the ViewHolder.
         * @param set to be bound.
         */
        fun bind(set: Set) {
            this.set = set
            binding.weights
                .setText(set.weights.toEmptyString(), TextView.BufferType.EDITABLE)
            binding.reps
                .setText(set.reps.toEmptyString(), TextView.BufferType.EDITABLE)
        }

        /**
         * Removes the [Set] instance associated with [getAdapterPosition] from the UI,
         * and prompts the display of a Snackbar where the user is presented with the option
         * of undoing said removal.
         */
        private fun removeSet() {
            val index = adapterPosition
            dataSetRemove(index)
            val snackbar = Snackbar.make(binding.root, R.string.delete_action, Snackbar.LENGTH_LONG)
                .setAction(R.string.undo) {
                    dataSetInsert(index, set)
                }
            snackbar.show()
        }
    }

    protected inner class SetAdapter: ListAdapter<Set, SetHolder>
        (AdapterUtil.DIFF_UTIL_SET_CALLBACK) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetHolder {
            val view = SetBinding.inflate(layoutInflater, parent, false)
            return SetHolder(view)
        }

        override fun onBindViewHolder(holder: SetHolder, position: Int) {
            val set = getItem(position)
            return holder.bind(set)
        }
    }
}