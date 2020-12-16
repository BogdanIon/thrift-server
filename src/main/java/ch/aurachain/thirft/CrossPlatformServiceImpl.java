package ch.aurachain.thirft;

import ch.aurachain.thirft.generated.CrossPlatformRepository;
import ch.aurachain.thirft.generated.CrossPlatformResource;
import ch.aurachain.thirft.generated.CrossPlatformService;
import ch.aurachain.thirft.generated.InvalidOperationException;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrossPlatformServiceImpl implements CrossPlatformService.Iface{

    @Autowired
    private CrossPlatformRepository crossPlatformRepository;

    @Override
    public CrossPlatformResource get(int id) throws InvalidOperationException, TException {
        return crossPlatformRepository.getCourse(id);
    }

    @Override
    public void save(CrossPlatformResource resource) throws InvalidOperationException, TException {

    }

    @Override
    public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
        return null;
    }

    @Override
    public boolean ping() throws InvalidOperationException, TException {
        return false;
    }
}
