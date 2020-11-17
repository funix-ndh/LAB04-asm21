drop table IF exists `guestbook`;
create table `guestbook` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `message` text NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `website` varchar(200),
  `img_url` varchar(200),
  `created_date` datetime NOT NULL
);
