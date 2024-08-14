import { Component } from '@angular/core';
import { Equipement } from "../../../models/equipement";
import { EquipementService } from "../../../services/equipement.service";

@Component({
  selector: 'app-list-equipement',
  templateUrl: './list-equipement.component.html',
  styleUrls: ['./list-equipement.component.css']
})
export class ListEquipementComponent {
  equipements: Equipement[] = [];
  showEditPopup = false;
  selectedEquipement: Equipement | null = null;

  constructor(private equipementService: EquipementService) {
    this.loadEquipements();
  }

  loadEquipements() {
    this.equipementService.getAllEquipements().subscribe(data => {
      this.equipements = data;
    });
  }

  deleteEquipement(id: number | undefined) {
    this.equipementService.deleteEquipement(id).subscribe(() => {
      this.loadEquipements();
    });
  }

  openEditPopup(equipement: Equipement) {
    this.selectedEquipement = equipement;
    this.showEditPopup = true;
  }

  closeEditPopup() {
    this.showEditPopup = false;
    this.selectedEquipement = null;
    this.loadEquipements();
  }
}
