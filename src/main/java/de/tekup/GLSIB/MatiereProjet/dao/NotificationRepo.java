package de.tekup.GLSIB.MatiereProjet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.GLSIB.MatiereProjet.entite.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Long>{

}
