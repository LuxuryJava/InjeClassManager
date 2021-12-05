INSERT INTO injecm.room (rinfo, doorOpen, isUsing, isProject, posiMen) VALUES ('A111', 0, 0, 1, 35);
INSERT INTO injecm.room (rinfo, doorOpen, isUsing, isProject, posiMen) VALUES ('A112', 0, 0, 0, 30);
INSERT INTO injecm.room (rinfo, doorOpen, isUsing, isProject, posiMen) VALUES ('A113', 0, 0, 1, 40);
INSERT INTO injecm.room (rinfo, doorOpen, isUsing, isProject, posiMen) VALUES ('A211', 0, 0, 0, 25);
INSERT INTO injecm.room (rinfo, doorOpen, isUsing, isProject, posiMen) VALUES ('A212', 0, 0, 1, 40);
INSERT INTO injecm.room (rinfo, doorOpen, isUsing, isProject, posiMen) VALUES ('A213', 0, 0, 0, 35);

insert into injecm.week (day)
values  ('금'),
        ('목'),
        ('수'),
        ('월'),
        ('일'),
        ('토'),
        ('화');

INSERT INTO injecm.notification (ntitle, ncontent) VALUES ('<공지사항> [2022학년도 1학기 제2전공 관련 안내]
', 'https://cs.inje.ac.kr/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD/?uid=3308&mod=document&pageid=1');
INSERT INTO injecm.notification (ntitle, ncontent) VALUES ('<공지사항> 2021-2 기말고사 시간표 안내
', 'https://cs.inje.ac.kr/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD/?uid=3465&mod=document&pageid=1');
INSERT INTO injecm.notification (ntitle, ncontent) VALUES ('<공지사항> 2021학년도 동계 계절학기 트랙 Ⅰ 폐강 안내
', 'https://cs.inje.ac.kr/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD/?uid=3468&mod=document&pageid=1');
INSERT INTO injecm.notification (ntitle, ncontent) VALUES ('<특강> 옥재 윤상길의 "가야 그리고 영혼의 불꽃" 도예展', 'https://navi.inje.ac.kr/program/E/ProgE0011S.aspx?yy=2021&smt=2&code=000000084&dept=01564&no=2&mc=0152');

INSERT INTO injecm.user (uno, upw, uname, department, email, phone, isManager) VALUES ('20163138', '123', '박중규', '컴퓨터공학부', 'park@daum.net', '010-3456-2454', 0);
INSERT INTO injecm.user (uno, upw, uname, department, email, phone, isManager) VALUES ('20182621', '123', '박성훈', '컴퓨터공학부', 'hoon@gmail.com', '010-7842-6098', 0);
INSERT INTO injecm.user (uno, upw, uname, department, email, phone, isManager) VALUES ('20203179', '123', '이나린', '컴퓨터공학부', 'rinn@naver.com', '010-2039-0516', 0);
INSERT INTO injecm.user (uno, upw, uname, department, email, phone, isManager) VALUES ('20203196', '123', '정민영', '컴퓨터공학부', 'min@naver.com', '010-2345-0421', 0);
INSERT INTO injecm.user (uno, upw, uname, department, email, phone, isManager) VALUES ('1111', '123', '관리자', '컴퓨터공학과사무실', 'cs@inje.kr', '055-320-3269', 1);

INSERT INTO injecm.reservation (uno, rinfo, day, mencnt, usetime, purpose, accept) VALUES ('20203196', 'A112', '월', 23, '18:00 ~ 18:50', '동아리 세미나', 0);
INSERT INTO injecm.reservation (uno, rinfo, day, mencnt, usetime, purpose, accept) VALUES ('20182621', 'A113', '수', 4, '21:00 ~ 21:50', '개인 세미나', 0);
INSERT INTO injecm.reservation (uno, rinfo, day, mencnt, usetime, purpose, accept) VALUES ('20203179', 'A212', '토', 40, '15:00 ~ 15:50', '자바 특강', 0);
INSERT INTO injecm.reservation (uno, rinfo, day, mencnt, usetime, purpose, accept) VALUES ('20163138', 'A213', '금', 5, '11:00 ~ 11:50', '프로젝트 실험', 0);
INSERT INTO injecm.reservation (uno, rinfo, day, mencnt, usetime, purpose, accept) VALUES ('20163138', 'A213', '수', 10, '11:00 ~ 11:50', '프로젝트 회의', 0);

INSERT INTO injecm.door (uno, rinfo, doorOpen) VALUES ('20163138', 'A213', 0);
INSERT INTO injecm.door (uno, rinfo, doorOpen) VALUES ('20182621', 'A113', 0);
INSERT INTO injecm.door (uno, rinfo, doorOpen) VALUES ('20203179', 'A212', 0);