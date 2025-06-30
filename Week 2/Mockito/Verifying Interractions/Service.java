import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// External dependency
interface ExternalApi {
    String getData();
}

// Service under test
class MyService {
    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Call method on service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify that the mock's getData method was called once
        verify(mockApi, times(1)).getData();
    }
}
