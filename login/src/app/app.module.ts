import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AuthContentComponent } from './auth-content/auth-content.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ContentComponent } from './content/content.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthContentComponent,
    LoginFormComponent,
    ContentComponent,
    WelcomeContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule 
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
