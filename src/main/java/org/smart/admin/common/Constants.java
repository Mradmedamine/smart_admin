package org.smart.admin.common;

public interface Constants {

	static final String SERVER_ADDED_SUCCESSFULLY_MESSAGE = "Server Added successfully";

	interface BotMessages {
		// TODO externalise this on messages
		String QUESTION_CREATE_DOSSIER = "Je veux constituer mon dossier";
		String QUESTION_COMMUNE = "Quelle est ma prefecture";
		String QUESTION_REGISTER = "Je veux m'inscrire";
		String QUESTION_DEPARTMENT = "Quel est mon departement";
		
		String ANSWER_REGISTER = "Cliquer sur le petit icone a  droite en haut de cette page : \n"
				+ "Vous pouvez s'inscrire en remplissant les champs avec vos informations en mettant "
				+ "votre mail et mot de passe ou en cliquant directement sur les icones de Facebook, Twitter ou Google+ pour se connecter avec.";
		String ANSWER_COMMUNE = "Vous pouvez activer votre localisation et \n on va detecter automatiquement votre departement ainsi que votre prefecture.";
		String ANSWER_CREATE_DOSSIER = "Il faut s'inscrire ou se logger d'abord et aller a  la section Mon dossier";
		String ANSWER_DEPARTMENT = "Vous pouvez activer votre localisation et on va detecter automatiquement votre departement ainsi que votre prefecture.";

		String WELCOME_MESSAGE = "Bonjour %s ! \n Comment puis-je vous aider ? ";

	}

}
