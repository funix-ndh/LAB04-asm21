drop table IF exists `photo_album`;
create table `photo_album` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `img_url` varchar(500) NOT NULL
);
