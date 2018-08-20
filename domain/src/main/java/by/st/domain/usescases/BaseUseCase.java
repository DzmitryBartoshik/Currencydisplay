package by.st.domain.usescases;

import by.st.domain.executors.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseUseCase {
    protected Scheduler executionThread;
    protected Scheduler postExecutionThread;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.executionThread = Schedulers.io();
        this.postExecutionThread = postExecutionThread.getScheduler();
    }
}
