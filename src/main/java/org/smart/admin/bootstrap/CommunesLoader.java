package org.smart.admin.bootstrap;

import org.smart.admin.model.entity.Commune;
import org.smart.admin.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CommunesLoader extends BaseDataLoader {

	@Autowired
	private CommuneRepository communeRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		if (isCreateMode()) 
		{
			populateData();
		}
	}

	private void populateData() {
		Commune commune = new Commune();
		commune.setInsee("77");
		commune.setAddress("https://goo.gl/maps/nrMdGTVEJHk");
		commune.setText("<div>\r\n" + "<b>Étape 1 - La constitution de votre dossier de demande </b> \r\n"
				+ "http://www.seine-et-marne.gouv.fr/content/download/30143/238787/file/renouvellement-d-une-carte-de-resident.pdf\r\n"
				+ "<br>\r\n"
				+ "Assurez-vous d''avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable  		\r\n"
				+ "</div>	<div><b>Étape 2 - La prise de rendez-vous </b> <br>\r\n"
				+ "Pour prendre rendez-vous : http://www.seine-et-marne.gouv.fr/booking/create/23977  </div><div><b>Étape 3 - L''envoi d''une convocation à votre attention par courriel par le bureau de l''admission au séjour de la sous-préfecture du Torcy</b> <br>\r\n"
				+ "Vous devrez vous présenter au rendez-vous fixé et fournir les documents exigés (listés à l''étape 1). Votre dossier devra être complet, sinon il sera refusé. “\r\n"
				+ "\"Demande_Nouveau_titreSejour\":\r\n"
				+ "<small>“Vous devez vous présenter à la sous-préfecture de Torcy, Bureau des étrangers 7, rue Gérard Philipe - Torcy, 77204 Marne-la-Vallée Cedex 1.Vous pouvez également pour des motifs légitimes, vous opposer au traitement des données vous concernant..</small></div>");
		communeRepository.save(commune);
	}
}
