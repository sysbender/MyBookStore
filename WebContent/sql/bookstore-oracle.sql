drop table t_item;
drop table t_order;
drop table t_book;
drop table t_category;
drop table t_user;

create table t_user(
  user_id varchar(32) primary key,
  username varchar(50) not null,
  password varchar(50) not null,
  email varchar(50) not null,
  code varchar(64) not null,
  state number(1,0)
);

insert  into t_user values ('1','aaa','aaa', 'aaa@gmail.com', '1234567890', 1);
insert  into t_user values ('2','bbb','bbb', 'bbb@gmail.com', '1234567890', 1);
insert  into t_user values ('3','ccc','ccc', 'ccc@gmail.com', '1234567890', 1);


create table t_category (
  category_id varchar(32) primary key,
  category_name varchar(100) not null
);

insert  into t_category  values ('1','JavaSE');
insert  into t_category values ('2','JavaEE');
insert  into t_category  values ('3','JavaScript');
insert  into t_category  values ('4','CSS');
insert  into t_category  values ('5','HTML');


create table t_book (
  book_id varchar(32) primary key,
  book_name varchar(100),
  price decimal(5,2),
  author varchar(20),
  image varchar(200),
  category_id varchar(32),
  description varchar(4000),
  language varchar(20),
  isbn varchar(20),
  foreign key (category_id) references t_category(category_id)
);



insert  into t_book values ('11','CSS Secrets: Better Solutions to Everyday Web Design Problems','36.43','Lea Verou','book_img/978-1449372637.jpg','4', 'In this practical guide, CSS expert Lea Verou provides 47 undocumented techniques and tips to help intermediate-to advanced CSS developers devise elegant solutions to a wide range of everyday web design problems. <br>Rather than focus on design, CSS Secrets shows you how to solve problems with code. You will learn how to apply Lea''s analytical approach to practically every CSS problem you face to attain DRY, maintainable, flexible, lightweight, and standards-compliant results.','English', '978-1449372637');
insert  into t_book values ('12','Core Java for the Impatient','37.77','Cay S. Horstmann','book_img/978-0321996329.jpg','1', 'The release of Java SE 8 introduced significant enhancements that impact the Core Java technologies and APIs at the heart of the Java platform. Many old Java idioms are no longer required and new features like lambda expressions will increase programmer productivity, but navigating these changes can be challenging.','English', '978-0321996329');
insert  into t_book values ('13','JavaScript Pocket Reference','14.86','David Flanagan','book_img/978-1449316853.jpg','3', 'JavaScript is the ubiquitous programming language of the Web, and for more than 15 years, JavaScript: The Definitive Guide has been the bible of JavaScript programmers around the world. Ideal for JavaScript developers at any level, this book is an all-new excerpt of The Definitive Guide, collecting the essential parts of that hefty volume into this slim yet dense pocket reference.','English', '978-1449316853');


insert  into t_book values ('21','JSP ET SERVLETS EFFICACES 2ÈME ÉDITION : PRODUCTION DE SITES DYNAMIQUES EN JAVA','124.25','Déléage J.-L.','book_img/978-2100513673.jpg','2', 'Vous trouverez dans ce livre les connaissances nécessaires pour construire un site dynamique riche, attrayant et robuste. L''auteur explique comment mettre en oeuvre simplement des JSP et construire des sites complets au moyen des servlets. Il détaille ensuite les concepts fondamentaux des servlets, ainsi que leurs applications pratiques, et décrit le positionnement des JSP et des servlets par rapport à d''autres architectures. De nombreux exemples pratiques (génération de classeurs Excel, de documents PDF) sont réutilisables. Cette nouvelle édition, complètement réécrite, met davantage l''accent sur les grands principes de développement objet (separation of concerns, inversion de dépendance) et l''architecture MVC. Elle intègre un chapitre sur Ajax, un autre sur le langage Unified EL et une brève présentation de quelques frameworks. L''auteur a pris le parti systématique des documents JSP (en XML) avec utilisation de EL. La partie sur les scriptlets est toujours disponible dans les compléments en ligne.','French', '978-2100513673');
insert  into t_book values ('22','PROGRAMMER EN JAVA 9E ÉD.','68.95','CLAUDE DELANNOY','book_img/978-2212128666.jpg','1', 'Dans cet ouvrage, Claude Delannoy applique au langage Java la démarche pédagogique qui a fait le succès de ses livres sur le C et le C++. Il insiste tout particulièrement sur la bonne compréhension des concepts objet et sur l''acquisition de méthodes de programmation rigoureuses. L''apprentissage du langage se fait en quatre étapes : apprentissage de la syntaxe de base, maîtrise de la programmation objet en Java, initiation à la programmation graphique et événementielle avec la bibliothèque Swing, introduction au développement Web avec les servlets Java et les JSP. L''ouvrage met l''accent sur les apports des versions 5 à 8 de Java Standard Edition : programmation générique, types énumérés, annotations... Un chapitre est dédié aux design patterns en Java et cette 9e édition comporte deux chapitres supplémentaires sur des nouveautés majeures de Java 8 : les streams et les expressions lambda ; la gestion du temps, des dates et des heures. Chaque notion nouvelle et chaque fonction du langage sont illustrées de programmes complets dont le code source est en libre téléchargement sur le site editions-eyrolles.','French', '978-2212128666');
insert  into t_book values ('23','Java 8 Apprendre la programmation orientée et maîtrisée','33.50','Thierry Groussard','book_img/978-2746095076.jpg','1', 'pratiques avec leurs corrigés. Des éléments sont en téléchargement sur www.editions-eni.fr. Un livre de la collection Ressources Informatiques Apprendre la Programmation Orientée Objet avec le langage Java Extrait du résumé : Ce livre s''adresse aux étudiants et aux développeurs ayant déjà une première expérience de la programmation structurée et qui sont désireux de passer à la Programmation Orientée Objet (POO) avec le langage Java, pour développer des applications portables… Les chapitres du livre : Avant-propos - Introduction à la POO - La conception orientée objet - Introduction à la plate-forme Java - Les types en Java - Création de classes - Héritage et polymorphisme - Communication entre objets - Le multithreading Un livre de la collection Ressources Informatiques JAVA 8 - Les fondamentaux du langage Java Extrait du résumé : Ce livre s''adresse à tout informaticien désirant développer sous Java. Que le lecteur soit débutant ou qu''il ait déjà une première expérience avec un autre langage il trouvera dans cet ouvrage toutes les bases nécessaires pour se familiariser rapidement avec un des langages les plus utilisés au monde…. Les chapitres du livre : Avant-propos - Présentation - Bases du langage - Programmation objet - Applications graphiques - Les applets - Accès aux bases de données - Déploiement d''applications','French', '978-2746095076');



create table t_order (
  order_id varchar(32) primary key,
  order_time date,
  total decimal(10,2),
  state number(1,0),
  user_id varchar(32),
  address varchar(200),
  foreign key (user_id) references t_user (user_id)
);


create table t_item (
  item_id varchar(32) primary key,
  count int,
  subtotal decimal(10,2),
  order_id varchar(32),
  book_id varchar(32),
  foreign key (order_id) references t_order (order_id),
  foreign key (book_id) references t_book (book_id)
);

commit;