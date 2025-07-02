package services;

import com.crowdar.api.rest.MethodsService;

public class BaseService extends MethodsService {
    public static final ThreadLocal<String> API_KEY = new ThreadLocal<>();
    public static final ThreadLocal<String> WORKSPACE_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_NAME = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> ID_CLIENTE = new ThreadLocal<>();
    public static final ThreadLocal<String> TIME_START = new ThreadLocal<>();
    public static final ThreadLocal<String> TIME_END = new ThreadLocal<>();
    public static final ThreadLocal<String> TIME_DESCRIPTION = new ThreadLocal<>();
    public static final ThreadLocal<String> ID_TIME_ENTRIES = new ThreadLocal<>();
}
