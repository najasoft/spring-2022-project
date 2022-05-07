package spring.cours.mvc.thymeleaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.cours.mvc.thymeleaf.model.Developpeur;
import spring.cours.mvc.thymeleaf.repository.DevRepository;

@Service
public class DevServiceImpl implements DevService {

	@Autowired
	DevRepository devRepository;

	@Override
	public void ajouter(Developpeur dev) {
		devRepository.save(dev);
	
	}

	@Override
	public List<Developpeur> getDevs() {
		return devRepository.findAll();

	}

	@Override
	public void supprimer(int idDev) {
		devRepository.deleteById(idDev);

	}

	@Override
	public void modifier(Developpeur dev) {
		
		if (devRepository.existsById(dev.getIdDev())) {
			Developpeur d = devRepository.getById(dev.getIdDev());
			d.setNom(dev.getNom());
			d.setDateEmbauche(dev.getDateEmbauche());
			d.setEmail(dev.getEmail());
			devRepository.save(d);
			
		}
		else
			devRepository.save(dev);

	}

	@Override
	public Developpeur getDeveloppeur(int idDev) {
		return devRepository.getById(idDev);
	}

}
