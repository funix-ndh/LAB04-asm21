drop table IF exists `wedding_blog`;
create table `wedding_blog` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `post_type` varchar(50) NOT NULL,
  `img_url` varchar(200) NULL,
  `paragraph` text NULL,
  `like_count` integer NOT NULL,
  `comment_count` integer NOT NULL,
  `published_date` date NOT NULL
);
