package by.st.currencydisplay.presentation.base.recycler;

import android.annotation.SuppressLint;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import by.st.currencydisplay.BR;
import by.st.currencydisplay.R;
import by.st.currencydisplay.presentation.screens.list.item.helper.ItemTouchHelperViewHolder;
import by.st.domain.entity.DomainModel;

public abstract class BaseItemViewHolder<
        Entity extends DomainModel,
        VM extends BaseItemViewModel<Entity>,
        B extends ViewDataBinding> extends RecyclerView.ViewHolder
        implements ItemTouchHelperViewHolder {

    private VM viewModel;
    private B binding;

    public BaseItemViewHolder(VM viewModel, B binding) {
        super(binding.getRoot());
        this.viewModel = viewModel;
        this.binding = binding;
        binding.setVariable(BR.viewModel, viewModel);
    }

    public void bindTo(Entity entity, int position) {
        viewModel.setItem(entity, position);
        binding.executePendingBindings();
    }

    public VM getViewModel() {
        return viewModel;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onItemSelected() {
        itemView.setBackgroundColor(R.color.colorAccent);
    }

    @Override
    public void onItemClear() {
        itemView.setBackgroundColor(0);
    }
}
