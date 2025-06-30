import org.mockito.ArgumentCaptor;

ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
verify(mockApi).getDataWithParams(captor.capture(), anyInt());

assertEquals("customer123", captor.getValue());


//✅ ✅ Done!
You’ve now:

Created a mock,

Called your service,

Verified that a specific interaction happened.
//