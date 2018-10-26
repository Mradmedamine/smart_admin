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
		commune.setText("<div>\r\n" + "<b><strong>Étape 1</strong> - La constitution de votre dossier de demande </b> \r\n"
			+ "<a href=\"http://www.seine-et-marne.gouv.fr/content/download/30143/238787/file/renouvellement-d-une-carte-de-resident.pdf\"> Documents demandés</a>\r\n"
			+ "<br>\r\n"
			+ "Assurez-vous d''avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable          \r\n"
			+ "</div>    <div><b><strong>Étape 2</strong> - La prise de rendez-vous </b> <br>\r\n"
			+ "Pour prendre rendez-vous : <a href= ' http://www.seine-et-marne.gouv.fr/booking/create/23977'> RDV </a>  </div><div><b><strong>Étape 3</strong> - " +
			"L''envoi d''une convocation à votre attention par courriel par le bureau de l''admission au séjour de la sous-préfecture du Torcy</b> <br>\r\n"
			+ "Vous devrez vous présenter au rendez-vous fixé et fournir les documents exigés (listés à l''étape 1). Votre dossier devra être complet, sinon il sera refusé. “\r\n"
			+ "\"Demande_Nouveau_titreSejour\":\r\n"
			+ "<small>“Vous devez vous présenter à la sous-préfecture de Torcy, Bureau des étrangers 7, rue Gérard Philipe - Torcy, 77204 Marne-la-Vallée Cedex 1.Vous pouvez également pour des motifs légitimes, " +
			"vous opposer au traitement des données vous concernant..</small></div>");
		communeRepository.save(commune);


		commune = new Commune();
		commune.setInsee("78");
		commune.setAddress("https://goo.gl/maps/dg6QYUtFsPQ2");
		commune.setText("<div>\r\n" +
			"<b><strong>Étape 1</strong> -je prends connaissance du tableau indiquant la répartition des compétences entre sous-préfecture et préfecture selon mon arrondissement de domicile :" +
			"<a href=\"http://www.yvelines.gouv.fr/Demarches-administratives/Accueil-des-etrangers-dans-les-Yvelines/Demande-de-titres-de-sejour/Ou-effectuer-mes-demarches\"> ICI </a>\r\n" +
			"- s’il s’agit d’une sous-préfecture, j’envoie mon dossier par voie postale. Je serai convoqué au cours de son instruction. \r\n" +
			"- s’il s’agit de la Préfecture de Versailles, je poursuis la demande de rendez-vous en ligne : <a href=' http://www.yvelines.gouv.fr/booking/create/6342'>RDV </a>\r\n" +
			"Exception, demande de rendez-vous par mail :\r\n" +
			"- pour les titres passeport talent, salarié ICT et leur famille, stagiaire ICT, stagiaire mobile ICT et famille, je demande un rendez-vous à : pref-etrangers-passtalent-ict@yvelines.gouv.fr\r\n" +
			"- pour les titres entrepreneur, profession libérale, je demande un rendez-vous à : pref-etrangers-entrepreneur-profliberale@yvelines.gouv.fr  \r\n" +
			"\r\n" +
			"<br>\r\n" +
			"Assurez-vous d'’avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable          \r\n" +
			"</div>    <div><b><strong>Étape 2</strong> - Je constitue mon dossier.\r\n" +
			"Je clique ici  : \r\n" +
			"<a href=\"http://www.yvelines.gouv.fr/Demarches-administratives/Accueil-des-etrangers-dans-les-Yvelines/Demande-de-titres-de-sejour\"> Dossier </a>\r\n" +

			"pour être orienté vers la liste des pièces à fournir ou je m’adresse au guichet d’accueil de la Préfecture du lundi au vendredi de 8h45 à 15h30.\r\n" +
			"Ce sont les mêmes documents à fournir que lors de votre 1ère demande, mais ils doivent être mis à jour en fonction de votre situation actuelle.\r\n" +
			"Je m’assure d’avoir toutes les pièces exigées. Un dossier incomplet sera refusé.\r\n" +
			"\r\n" +
			"</div><div><b><strong>Étape 3</strong>: Il est très important de donner une adresse e-mail valide et accessible rapidement car une fois la réservation effectuée en ligne, il faut la confirmer.\r\n" +
			"Pour confirmer le rendez-vous, un e-mail est envoyé à l’adresse fournie contenant un lien qui servira à valider la réservation dans un délai de 15 min.\r\n" +
			"La préfecture se réserve le droit d'annuler un rendez-vous. En cas d'annulation, vous recevrez une notification de cette annulation par messagerie.\r\n" +
			"</b> <br>\r\n" +
			"Vous devrez vous présenter au rendez-vous fixé et fournir les documents exigés (listés à l'étape 1). Votre dossier devra être complet, sinon il sera refusé. \r\n" +
			"\r\n" +
			"<small>\r\n" +
			"le Préfet des Yvelines, 1 rue Jean Houdon 78010 Versailles Cedex\r\n" +
			".</small></div>");

		communeRepository.save(commune);


		commune = new Commune();
		commune.setInsee("28");
		commune.setAddress("https://goo.gl/maps/yAZaz48Lupt");
		commune.setText("\r\n" +
			"<div>\r\n" +
			"<b><strong>Étape 1</strong> - La constitution de votre dossier de demande </b> \r\n" +
			"<a href=\"http://www.eure.gouv.fr/content/download/16760/116231/file/Etudiant.pdf\"> Documents demandés</a>\r\n" +
			"<br>\r\n" +
			"Assurez-vous d'’avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable          \r\n" +
			"</div>    <div><b><strong>Étape 2</strong> - La prise de rendez-vous </b> <br>\r\n" +
			"Pour prendre rendez-vous :<a href=\" http://www.loir-et-cher.gouv.fr/booking/create/733\">RDV</a>  </div><div><b>\r\n" +
			"<strong>Étape 3</strong> - La préfecture de Loir et Cher reçoit obligatoirement en rendez-vous individuel tout ressortissant étranger qui sollicite :\r\n" +
			"une première demande de titre de séjour\r\n" +
			"le renouvellement de son titre de séjour\r\n" +
			"un changement d'adresse sur son titre de séjour\r\n" +
			"la délivrance d'un document de circulation pour étrangers mineurs ou d'un titre d'identité républicain.\r\n" +
			"\r\n" +
			"Conformément à la loi \"informatique et libertés\" du 6 janvier 1978 modifiée en 2004, vous disposez d'un droit d'accès et de rectification aux informations qui vous " +
			"concernent que vous pouvez exercer en vous adressant à :\r\n" +
			"Préfecture de Loir-et-Cher\r\n" +
			"Place de la République\r\n" +
			"BP 40299\r\n" +
			"41006 BLOIS CEDEX\r\n" +
			"\r\n" +
			"La Préfecture de Loir-et-Cher se réserve le droit d'annuler un rendez-vous. En cas d'annulation d'un rendez-vous, vous recevrez une notification de cette annulation par messagerie.\r\n" +
			"Pour les demandes de renouvellement de titre de séjour, merci de remplir le formulaire à télécharger ici : " +
			"<a href=\"http://www.loir-et-cher.gouv.fr/content/download/8503/55683/file/Imprim%C3%A9%20Dde%20de%20Titre%202017.pdf\"> Fromulaire</a>, ou à défaut il vous sera remis à l'accueil.\r\n" +
			"google.fr 16 Place Jean Jaurès to Prefecture of Loir-et-Cher"+
			"Find local businesses, view maps and get driving directions in Google Maps. loir-et-cher.gouv.fr Renouvellement d'un titre de séjour - Les services de l'État en Loir-et-Cher"+
			"Portail des services de l'Etat en Loir-et-Cher"+
			"Assurez-vous que votre dossier est complet\r\n" +
			"</div>\r\n"
		);
		communeRepository.save(commune);



		commune = new Commune();
		commune.setInsee("41");
		commune.setAddress("https://goo.gl/maps/S798KxXEqoH2");
		commune.setText("\r\n" +
			"<div>\r\n" +
			"<b><strong>Étape 1 </strong>- La constitution de votre dossier de demande: </b> \r\n" +
			"<a href=\" http://41.accueil-etrangers.gouv.fr/demande-de-titre-de-sejour/vous-etes-ressortissant-e-non-europeen-ne/vous-etes-ressortissant-e-de-pays-tiers-non-algerien-ne/" +
			"vous-etes-en-france-vous-avez-deja-un-titre-de-sejour/vous-souhaitez-obtenir-son-renouvellement/pour-l-obtention-d-une-carte-de-sejour-temporaire/article/en-tant-que-travailleur-" +
			"temporaire\"> Documents demandés</a>\r\n" +
			"<br>\r\n" +
			"Assurez-vous d’avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable          \r\n" +
			"</div>    <div><b><strong>Étape 2 </strong>- La prise de rendez-vous </b> <br>\r\n" +
			"Pour prendre rendez-vous :<a href=\" http://www.loir-et-cher.gouv.fr/booking/create/733 \"> RDV </a>  </div><div><b><strong>Étape 3 </strong>-La préfecture de Loir et Cher " +
			"reçoit obligatoirement en rendez-vous individuel tout ressortissant étranger qui sollicite :\r\n" +
			"une première demande de titre de séjour\r\n" +
			"le renouvellement de son titre de séjour\r\n" +
			"un changement d'adresse sur son titre de séjour\r\n" +
			"la délivrance d'un document de circulation pour étrangers mineurs ou d'un titre d'identité républicain.\r\n" +
			"\r\n" +
			"Conformément à la loi \"informatique et libertés\" du 6 janvier 1978 modifiée en 2004, vous disposez d'un droit d'accès et de rectification aux informations qui vous concernent " +
			"que vous pouvez exercer en vous adressant à :\r\n" +
			"Préfecture de Loir-et-Cher\r\n" +
			"Place de la République\r\n" +
			"BP 40299\r\n" +
			"41006 BLOIS CEDEX\r\n" +
			"\r\n" +
			"La Préfecture de Loir-et-Cher se réserve le droit d'annuler un rendez-vous. En cas d'annulation d'un rendez-vous, vous recevrez une notification de cette annulation par messagerie.\r\n" +
			"Pour les demandes de renouvellement de titre de séjour, merci de remplir <a href='  http://www.loir-et-cher.gouv.fr/content/download/8503/55683/file/Imprim%C3%A9%20Dde%20de%20Titre%202017.pdf '> " +
			"Formulaire </a>, ou à défaut il vous sera remis à l'accueil.</div>\r\n" +
			"");
		communeRepository.save(commune);



		commune = new Commune();
		commune.setInsee("37");
		commune.setAddress("https://goo.gl/maps/G6nA4ivmrNK2");
		commune.setText("<div>\r\n" +
			"<b><strong>Étape 1</strong> - La constitution de votre dossier de demande </b> \r\n" +
			"<a href=\"http://www.indre-et-loire.gouv.fr/content/download/21573/147620/file/Dossier-etudiant-2018.pdf\"> Documents demandés</a>\r\n" +
			"<br>\r\n" +
			"Assurez-vous d'’avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable          \r\n" +
			"</div>    <div>\r\n" +
			"\r\n" +
			"<b><strong>Étape 2 </strong>- La prise de rendez-vous </b> <br>\r\n" +
			"Pour prendre rendez-vous : <a href=' http://www.indre-et-loire.gouv.fr/booking/create/4110'> RDV </a>  </div><div>\r\n" +
			"\r\n" +
			"<b><strong>Étape 3 </strong>- Les informations recueillies au cours de cette procédure visant à l'obtention d'un rendez-vous sont à l'usage exclusif de la préfecture et sont " +
			"utilisées à des fins de communication.\r\n" +
			"Conformément à la loi \"informatique et libertés\" du 6 janvier 1978 modifiée en 2004, vous disposez d'un droit d'accès et de rectification aux informations qui vous concernent " +
			"que vous pouvez exercer en vous adressant à :\r\n" +
			"Préfecture d'Indre-et-Loire\r\n" +
			"15, rue Bernard Palissy\r\n" +
			"37000 TOURS\r\n" +
			"La Préfecture d'Indre-et-Loire se réserve le droit d'annuler un rendez-vous.\r\n" +
			"En cas d'annulation d'un rendez-vous, vous recevrez une notification de cette annulation par messagerie.\r\n" +
			"</div>\r\n" +
			"");
		communeRepository.save(commune);


		commune = new Commune();
		commune.setInsee("36");
		commune.setAddress("https://goo.gl/maps/ezADSPTFt832");
		commune.setText("\r\n" +
			"<div>\r\n" +
			"<b><strong>Étape 1 </strong>- La constitution de votre dossier de demande </b> \r\n" +
			"Votre visa de long séjour\r\n" +
			"Votre passeport (pages relatives à l'état civil, aux dates de validité et aux cachets d'entrée)\r\n" +
			"Acte de naissance (copie intégrale ou extrait avec filiation)\r\n" +
			"Si vous êtes marié : carte de séjour (ou carte d'identité) de votre époux et extrait d'acte de mariage\r\n" +
			"Si vous avez des enfants : extraits d'acte de naissance de vos enfants avec filiation\r\n" +
			"Justificatif de domicile datant de moins de 3 mois\r\n" +
			"3 photos\r\n" +
			"Autorisation de travail correspondant au poste occupé (formulaire cerfa n°15187*02 ou cerfa n°15186*02 visé par la Direccte)\r\n" +
			"Attestation de présence dans l'emploi établie par votre employeur ou copie des 3 derniers bulletins de paie\r\n" +
			"Attestation de l'Ofii de clôture ou de suivi des actions prévues au contrat d'intégration républicaine\r\n" +
			"Le certificat médical délivré par l'Ofii est demandé lors de la remise de la carte\r\n" +
			"Le justificatif d'acquittement du droit de timbre (demandé lors de la remise de la carte)\r\n" +
			"À savoir\r\n" +
			"les actes d'état civil doivent être obligatoirement accompagnés de leur traduction en français par un traducteur interprète agréé.\r\n" +
			"\r\n" +
			"<br>\r\n" +
			"Assurez-vous d'’avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable          \r\n" +
			"</div>    <div>\r\n" +
			"\r\n" +
			"<b><strong>Étape 2 </strong>- La prise de rendez-vous </b> <br>\r\n" +
			"Pour prendre rendez-vous :<a href=\"http://www.indre.gouv.fr/booking/create/15439/\" > RDV </a>  </div><div>\r\n" +
			"\r\n" +
			"<b><strong>Étape 3</strong> - Prise de rendez-vous pour le dépôt d’un dossier de première demande d'un titre de séjour ou pour un document de circulation pour étrangers mineur ou une demande d'asile.\r\n" +
			"indre-et-loire.gouv.fr Obtenir la carte de séjour étudiants - Les services de l'État en Indre-et-Loire Portail de l'Etat en Indre-et-Loire google.fr Prefecture of Indre· Prefecture · Place de la Victoire et des Alliés"+
			"Attention, un seul rendez-vous est possible. Si vous devez modifier votre rendez-vous, vous devez supprimer le rendez-vous en cours de validité avant de pouvoir de nouveau faire une demande. Un lien \"Cliquez ici pour gérer vos demandes de rendez-vous\" dans votre courriel de confirmation vous permet de faire l'annulation.\r\n" +
			"La Préfecture de l'Indre se réserve le droit d'annuler un rendez-vous.\r\n" +
			"En cas d'annulation d'un rendez-vous, vous recevrez une notification de cette annulation par messagerie.\r\n" +
			"Le site de la préfecture a fait l’objet d’une déclaration à la Commission Nationale de l’Informatique et des Libertés (CNIL) sous le n° 712957. Conformément aux dispositions de la loi n° 78-17 du 6 janvier 1978 relative à l’informatique, aux fichiers et aux libertés, vous disposez d’un droit d’accès, de modification, de rectification " +
			"et de suppression des données qui vous concernent. Pour demander une modification, rectification ou suppression des données vous concernant, il vous suffit d’envoyer un courrier par voie électronique ou postale à la Documentation française en justifiant de votre identité.\r\n" +
			"Les informations recueillies au cours de cette procédure sont à l'usage exclusif de la préfecture\r\n" +
			"\r\n" +
			"</div>\r\n" +
			"");
		communeRepository.save(commune);



		commune = new Commune();
		commune.setInsee("18");
		commune.setAddress("https://goo.gl/maps/RDTLMhPTn242");
		commune.setText("<div>\r\n" +
			"<b><strong>Étape 1</strong> - La constitution de votre dossier de demande </b> \r\n" +
			"<a href=\" http://18.accueil-etrangers.gouv.fr\"> Documents demandés</a>/\r\n" +
			"<br>\r\n" +
			"Assurez-vous d'’avoir toutes les pièces exigées. La liste des documents à fournir le jour du rendez-vous est consultable   \r\n" +
			"</div>    <div>\r\n" +
			"\r\n" +
			"<b><strong>Étape 2 </strong>- La prise de rendez-vous </b> <br>\r\n" +
			"Pour prendre rendez-vous : <a href=\"http://www.cher.gouv.fr/Enquetes/Demande-de-RDV\"> RDV</a>  </div><div>\r\n" +
			"\r\n" +
			"<b><strong>Étape 3</strong> - Le dépôt des demandes de titres de séjour sont à effectuer à la Préfecture à BOURGES quel que soit votre lieu de domicile dans le Cher.\r\n" +
			"Tout dossier incomplet ne sera pas recevable (rappel : le dossier doit comporter l’original et la copie de chaque document).\r\n" +
			"Tout document établi en langue étrangère devra être accompagné de sa traduction effectuée par un traducteur assermenté par une Cour d'Appel en France.\r\n" +
			"Les demandes suivantes se font uniquement sur rendez-vous : \r\n" +
			"1ère demande de titres de séjour\r\n" +
			"renouvellement de titres de séjour (mis en place depuis juillet 2013)\r\n" +
			"changement d'adresse\r\n" +
			"duplicata de titres de séjour (cas de perte ou de vol),\r\n" +
			"changement de statut,\r\n" +
			"modification d'état civil \r\n" +
			"Une fois le titre de séjour fabriqué, il vous sera remis uniquement le jeudi après midi (vous en serez informé par SMS).\r\n" +
			"</div>\r\n" +
			"");
		communeRepository.save(commune);
		
	}
}
