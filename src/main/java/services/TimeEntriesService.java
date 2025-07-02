package services;


import api.model.TimeTrakerMod.TimeTrakerModel;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class TimeEntriesService extends BaseService {

    public static Response put(String jsonName) {
        return put(jsonName, TimeTrakerModel.class, setParams());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, TimeTrakerModel.class, setParams());
    }

    public static Response get(String jsonName) {
        return get(jsonName, TimeTrakerModel.class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY.get());
        params.put("workspaceId", WORKSPACE_ID.get());
        if (ID_CLIENTE.get() != null) {
            params.put("idCliente", ID_CLIENTE.get());
        } else {
            params.put("idCliente", "");
        }

        if(TIME_START.get()!=null){
            params.put("start", TIME_START.get());
        }
        if(TIME_START.get()!=null){
            params.put("end", TIME_END.get());
        }
        if(TIME_DESCRIPTION.get()!=null){
            params.put("description", TIME_DESCRIPTION.get());
        }

        if(ID_TIME_ENTRIES.get()!=null){
            params.put("idTimeEntries", ID_TIME_ENTRIES.get());
        }

        return params;
    }
}
