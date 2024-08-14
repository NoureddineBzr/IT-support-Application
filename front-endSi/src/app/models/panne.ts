import {Equipement} from "./equipement";
import {TicketDeSupport} from "./ticket-de-support";

export interface Panne {
  id: number;
  description: string;
  datePanne: Date;
  resolu: boolean;
  equipement: Equipement;
  tickets: TicketDeSupport[];
}
