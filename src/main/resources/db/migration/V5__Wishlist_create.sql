drop table IF exists `wishlist`;
create table `wishlist` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `content` text NOT NULL
);
