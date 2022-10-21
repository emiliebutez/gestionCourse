-- apply changes
create table if not exists chauffeur (
  id                            integer not null,
  nom                           varchar(255),
  prenom                        varchar(255),
  num_permis                    integer not null,
  constraint pk_chauffeur primary key (id)
);

create table if not exists coureur (
  id                            integer not null,
  nom                           varchar(255),
  prenom                        varchar(255),
  date_naissance                timestamp,
  groupe_sanguin                varchar(255),
  constraint pk_coureur primary key (id)
);

create table if not exists coureur_participation (
  coureur_id                    integer not null,
  participation_num_inscription integer not null,
  constraint pk_coureur_participation primary key (coureur_id,participation_num_inscription),
  foreign key (coureur_id) references coureur (id) on delete restrict on update restrict,
  foreign key (participation_num_inscription) references participation (num_inscription) on delete restrict on update restrict
);

create table if not exists course (
  id                            integer not null,
  nom                           varchar(255),
  constraint pk_course primary key (id)
);

create table if not exists edition (
  id                            integer not null,
  annee                         integer not null,
  date_debut                    timestamp,
  date_fin                      timestamp,
  ville_depart                  varchar(255),
  ville_arrivee                 varchar(255),
  pays_depart                   varchar(255),
  pays_arrivee                  varchar(255),
  distance                      float not null,
  annulee                       integer(1) default 0 not null,
  course_id                     integer not null,
  constraint pk_edition primary key (id),
  foreign key (course_id) references course (id) on delete restrict on update restrict
);

create table if not exists equipe (
  id                            integer not null,
  nom_responsable               varchar(255),
  prenom_responsable            varchar(255),
  mail_responsable              varchar(255),
  tel_responsable               varchar(255),
  nationnalite                  varchar(255),
  nom_equipe                    varchar(255),
  constraint pk_equipe primary key (id)
);

create table if not exists etape (
  id                            integer not null,
  ville_depart                  varchar(255),
  ville_arrivee                 varchar(255),
  pays_depart                   varchar(255),
  pays_arrivee                  varchar(255),
  distance                      float not null,
  num_ordre                     integer not null,
  etat_etape                    integer,
  edition_id                    integer,
  nb_sprint                     integer not null,
  nb_col                        integer not null,
  constraint ck_etape_etat_etape check ( etat_etape in (0,1,2,3)),
  constraint pk_etape primary key (id),
  foreign key (edition_id) references edition (id) on delete restrict on update restrict
);

create table if not exists participation (
  num_inscription               integer not null,
  etat_participation            integer,
  participation_equipe_num_inscription integer,
  coureur_id                    integer,
  constraint ck_participation_etat_participation check ( etat_participation in (0,1,2,3)),
  constraint pk_participation primary key (num_inscription),
  foreign key (participation_equipe_num_inscription) references participation_equipe (num_inscription) on delete restrict on update restrict,
  foreign key (coureur_id) references coureur (id) on delete restrict on update restrict
);

create table if not exists participation_equipe (
  num_inscription               integer not null,
  etat_participation            integer,
  equipe_id                     integer,
  edition_id                    integer,
  constraint ck_participation_equipe_etat_participation check ( etat_participation in (0,1,2,3)),
  constraint pk_participation_equipe primary key (num_inscription),
  foreign key (equipe_id) references equipe (id) on delete restrict on update restrict,
  foreign key (edition_id) references edition (id) on delete restrict on update restrict
);

create table if not exists performance (
  id                            integer not null,
  temps                         float not null,
  points_sprint                 integer not null,
  points_grimp                  integer not null,
  participation_num_inscription integer,
  etape_id                      integer,
  constraint pk_performance primary key (id),
  foreign key (participation_num_inscription) references participation (num_inscription) on delete restrict on update restrict,
  foreign key (etape_id) references etape (id) on delete restrict on update restrict
);

create table if not exists vehicule_assistance (
  id                            integer not null,
  immatriculation               varchar(255),
  chauffeur_id                  integer,
  participation_equipe_num_inscription integer,
  constraint pk_vehicule_assistance primary key (id),
  foreign key (chauffeur_id) references chauffeur (id) on delete restrict on update restrict,
  foreign key (participation_equipe_num_inscription) references participation_equipe (num_inscription) on delete restrict on update restrict
);

