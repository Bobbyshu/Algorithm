-- Query the list of CITY names from STATION which have vowels (i.e., a, e, i, o, and u) as
-- both their first and last characters. Your result cannot contain duplicates.
-- regular expression ^ for prefix, $ for suffix and [] for string set to query
SELECT DISTINCT CITY
FROM STATION
WHERE CITY RLIKE '^[AEIOU]' AND CITY RLIKE '[aeiou]$';

-- Query the Name of any student in STUDENTS who scored higher than  Marks. 
-- Order your output by the last three characters of each name. 
-- If two or more students both have names ending in the same last three characters (i.e.: Bobby, Robby, etc.), 
-- secondary sort them by ascending ID.
-- sort use comma separate and Right function to get character from string
select name
from students
where marks > 75
order by RIGHT(name, 3), ID asc
