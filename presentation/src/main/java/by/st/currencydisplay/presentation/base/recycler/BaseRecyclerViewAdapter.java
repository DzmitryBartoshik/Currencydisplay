package by.st.currencydisplay.presentation.base.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import by.st.currencydisplay.presentation.screens.list.item.helper.ItemTouchHelperAdapter;
import by.st.domain.entity.DomainModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public abstract class BaseRecyclerViewAdapter<
        Entity extends DomainModel,
        VM extends BaseItemViewModel<Entity>>
        extends RecyclerView.Adapter<BaseItemViewHolder<Entity, VM, ?>>
        implements ItemTouchHelperAdapter {

    private List<Entity> items = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull BaseItemViewHolder<Entity, VM, ?> holder, int position) {
        holder.bindTo(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Entity> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public void onItemDismiss(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Entity prev = items.remove(fromPosition);
        items.add(toPosition > fromPosition ? toPosition - 1 : toPosition, prev);
        notifyItemMoved(fromPosition, toPosition);
    }
}
