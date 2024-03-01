import { Component, Output,EventEmitter } from '@angular/core';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  @Output() onSubmitLoginEvent = new EventEmitter();
  login: string = "";
  password: string = "";
  active: any;
  
  onSubmitLogin(): void {
    this.onSubmitLoginEvent.emit({ login: this.login, password: this.password });
  }
  


}
