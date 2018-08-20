package by.st.currencydisplay.presentation.base.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import by.st.currencydisplay.BR;
import by.st.domain.entity.DomainModel;

public abstract class BaseItemViewHolder<
    Entity extends DomainModel,
    VM extends BaseItemViewModel<Entity>,
    B extends ViewDataBinding> extends RecyclerView.ViewHolder{

        private VM viewModel;
        private B binding;

        public BaseItemViewHolder(VM viewModel, B binding) {
            super(binding.getRoot());
            this.viewModel = viewModel;
            this.binding = binding;
            binding.setVariable(BR.viewModel, viewModel);
        }

        public void bindTo(Entity entity, int position){
            viewModel.setItem(entity);
            binding.executePendingBindings();
        }

        public VM getViewModel() {
            return viewModel;
        }
}
