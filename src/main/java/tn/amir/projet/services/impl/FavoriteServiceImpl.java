package tn.amir.projet.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.amir.projet.entity.Favorite;
import tn.amir.projet.entity.Property;
import tn.amir.projet.entity.User;
import tn.amir.projet.repository.FavoriteRepository;
import tn.amir.projet.repository.PropertyRepository;
import tn.amir.projet.repository.UserRepository;
import tn.amir.projet.services.IFavoriteService;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
	
	@Autowired
	FavoriteRepository favo;

	@Autowired
	UserRepository us;

	@Autowired
	PropertyRepository prop;

	// ajout favorite
		@Override
		public boolean ajouterFavorite(Integer user, Integer property) {
			Property P = prop.findById(property).get();
			User U = (User) us.findById(user).get();
			Favorite f = new Favorite();
			f.setUser(U);
			f.setProperty(P);

			if (this.rechercherFavorite(f) == false) {
				U.addFavorite(f);
				favo.save(f);
				return true;
			}

			return false;
		}
		
		// Rechercher Favorites
		@Override
		public boolean rechercherFavorite(Favorite f) {
			Favorite search = favo.findfavoritenotbyid(f.getUser(), f.getProperty()).orElse(null);
			if (search != null)
				return true;
			else
				return false;
		}

		@Override
		public void deleteFavoriteById(int favoriteId) {
			favo.deleteById(favoriteId);
			
		}

		@Override
		public List<Favorite> getAllFavorites(int id) {
			User u = us.findById(id).get();
			return u.getFavoris();
		}
		
		public void sendSms(String to, String from, String body) {

			try {
				Twilio.init("AC4a30225de4e58465a1bb6e3a9b0348d5", "36f1f7e143fd687d791e1db7d3fbeefc");
				Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
		
		// Favorites Modified (for notification)
		@Override
		public List<Favorite> getfavoriteswhoseassetgotupdated(Property P) {
			List<Favorite> liste = (List<Favorite>) favo.findfavsbyproperty(P);
			List<User> user = new ArrayList<User>();

			for (int i = 0; i < liste.size(); i++) {
				user.add(liste.get(i).getUser());
				
				String s = "+216" + liste.get(i).getUser().getPhoneNumber();

				sendSms(s, "+14044917812", "A favorite asset has been changed!");

			}

			return liste;
		}
		
		

}
