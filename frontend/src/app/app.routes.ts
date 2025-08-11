import { Routes } from '@angular/router';
import { HomeGalleryComponent } from './home-gallery/home-gallery.component';
import { ContactFormComponent } from './contact-form/contact-form.component';

export const routes: Routes = [
    { path: 'contact', component: ContactFormComponent }, // Home route shows contact form
  { path: '', component: HomeGalleryComponent }
];
