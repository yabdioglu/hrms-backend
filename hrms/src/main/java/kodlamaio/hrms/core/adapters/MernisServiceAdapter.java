package kodlamaio.hrms.core.adapters;


import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserCheckService {

	private boolean result;
	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
        this.result = false;
        try {
            result = client.TCKimlikNoDogrula(
                    Long.parseLong(candidate.getIdentityNumber()),
                    candidate.getFirstName().toUpperCase(),
                    candidate.getLastName().toUpperCase(), 
                    candidate.getBirthYear()
                    );
        }catch (RemoteException e) {
            e.printStackTrace();
        }
        return this.result;
	}
}
