package by.st.currencydisplay.presentation.base.recycler;

import by.st.domain.entity.DomainModel;

public abstract class BaseItemViewModel<Entity extends DomainModel> {

    public abstract void setItem(Entity entity, int position);
}
