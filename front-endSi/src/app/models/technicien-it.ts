import {Rapport} from "./rapport";
import {TicketDeSupport} from "./ticket-de-support";
import {Personne} from "./personne";

export interface TechnicienIT extends Personne {
  ticketsSupport: TicketDeSupport[];
  reports: Rapport[];
}
