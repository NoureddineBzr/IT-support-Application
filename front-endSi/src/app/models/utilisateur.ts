import {TicketDeSupport} from "./ticket-de-support";
import {Personne} from "./personne";

export interface Utilisateur extends Personne {
  ticketsSupport: TicketDeSupport[];
}
