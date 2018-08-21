package by.st.currencydisplay.presentation.screens.list.item.helper;

public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}