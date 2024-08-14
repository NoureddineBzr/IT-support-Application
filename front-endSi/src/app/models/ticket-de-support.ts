import {EtatTicket} from "./enums/etat-ticket";
import {Utilisateur} from "./utilisateur";
import {TechnicienIT} from "./technicien-it";
import {Panne} from "./panne";

export interface TicketDeSupport {
  id: number;
  description: string;
  etat: EtatTicket;
  dateCreation: Date;
  dateResolution: Date;
  utilisateur: Utilisateur;
  technicienIT: TechnicienIT;
  panne: Panne;
}
