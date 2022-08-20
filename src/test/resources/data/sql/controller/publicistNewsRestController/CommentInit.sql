delete from public.comments;

-- users init
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (2, null, '2022-08-14', '1', '1', '1', '1');
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (3, null, '2022-08-14', '1', '1', '1', '1');
INSERT INTO public.users (id, avatar_url, birthday, email, first_name, last_name, password)
VALUES (4, null, '2022-08-14', '1', '1', '1', '1');

-- news init
INSERT INTO public.news(
    id, rubric, date, title, html_body, user_id)
VALUES (2, 'NEWS', '2022-08-03', 'db test title 01', 'nytipobody', 2);
INSERT INTO public.news(
    id, rubric, date, title, html_body, user_id)
VALUES (3, 'NEWS', '2022-08-04', 'db test title 02', 'nytipobody', 3);
INSERT INTO public.news(
    id, rubric, date, title, html_body, user_id)
VALUES (4, 'TESTS', '2022-08-05', 'db test title 03', 'nytipobody', 4);

-- comment init
INSERT INTO public.comments(id, date, text, news_id, user_id)
VALUES (2, '2022-08-20 03:07:04.000000','test comment 01', 2, 2);

INSERT INTO public.comments(id, date, text, news_id, user_id)
VALUES (3, '2022-07-20 03:07:04.000000','test comment 02', 3, 3);

INSERT INTO public.comments(id, date, text, news_id, user_id)
VALUES (4, '2022-06-20 03:07:04.000000','test comment 03', 4, 4);
