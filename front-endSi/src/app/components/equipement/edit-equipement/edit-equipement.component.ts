import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Equipement } from "../../../models/equipement";
import { EquipementService } from "../../../services/equipement.service";

@Component({
  selector: 'app-edit-equipement',
  templateUrl: './edit-equipement.component.html',
  styleUrls: ['./edit-equipement.component.css']
})
export class EditEquipementComponent {
  @Input() equipement: Equipement | null = null;
  @Output() closePopup = new EventEmitter<void>();  // Renamed to avoid duplicate identifier

  constructor(private equipementService: EquipementService) {}

  onSubmit() {
    if (this.equipement) {
      this.equipementService.updateEquipement(this.equipement).subscribe(() => {
        this.closePopup.emit();  // Emit event to close popup
      });
    }
  }

  closePopupMethod() {
    this.closePopup.emit();  // Emit event to close popup
  }
}
