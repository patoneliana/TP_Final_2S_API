package api.config;

import services.*;

public enum EntityConfiguration {

    TIMETRAKER {
        @Override
        public Class<?> getEntityService() {
            return TimeTrakerService.class;
        }

    }, TIMEENTRIES {
        @Override
        public Class<?> getEntityService() {
            return TimeEntriesService.class;
        }

    };


    public abstract Class<?> getEntityService();
}



