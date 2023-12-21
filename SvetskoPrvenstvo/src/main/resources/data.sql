INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');


  
 INSERT INTO reprezentacija(id,naziv,skraceni_naziv) VALUES (1,'Srbija','SRB');
 INSERT INTO reprezentacija(id,naziv,skraceni_naziv) VALUES (2,'Argentina','ARG');
 INSERT INTO reprezentacija(id,naziv,skraceni_naziv) VALUES (3,'Portugal','POR');
 INSERT INTO reprezentacija(id,naziv,skraceni_naziv) VALUES (4,'Francuska','FRA');
 
              
 INSERT INTO igrac(id,ime,prezime,postignuti_golovi,reprezentacija_id) VALUES (1,'Dusan','Vlahovic', 3,1);
 INSERT INTO igrac(id,ime,prezime,postignuti_golovi,reprezentacija_id) VALUES (2,'Lionel','Mesi', 10,2);
 INSERT INTO igrac(id,ime,prezime,postignuti_golovi,reprezentacija_id) VALUES (3,'Kristiano','Ronaldo', 7,3);
 INSERT INTO igrac(id,ime,prezime,postignuti_golovi,reprezentacija_id) VALUES (4,'Kilian','Embape', 12,4);
              
 INSERT INTO utakmica(id,reprezentacijaB_id,reprezentacijaA_id,goloviA,goloviB) VALUES(1,1,2,2,3);
 INSERT INTO utakmica(id,reprezentacijaB_id,reprezentacijaA_id,goloviA,goloviB) VALUES(2,3,4,3,5); 