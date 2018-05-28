-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: cb1
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `codemasters_questions`
--

DROP TABLE IF EXISTS `codemasters_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codemasters_questions` (
  `Q_ID` int(2) NOT NULL,
  `problem_statement` varchar(2000) NOT NULL,
  `ip_format` varchar(2000) NOT NULL,
  `op_format` varchar(2000) NOT NULL,
  `sample_testcase` varchar(2000) NOT NULL,
  `max_score` int(3) NOT NULL DEFAULT '50',
  PRIMARY KEY (`Q_ID`),
  UNIQUE KEY `Q_ID` (`Q_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codemasters_questions`
--

LOCK TABLES `codemasters_questions` WRITE;
/*!40000 ALTER TABLE `codemasters_questions` DISABLE KEYS */;
INSERT INTO `codemasters_questions` VALUES (1,'abcd','1','2','3',100),(2,'efgh','2','3','4',200);
/*!40000 ALTER TABLE `codemasters_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mcq_questions`
--

DROP TABLE IF EXISTS `mcq_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mcq_questions` (
  `Q_ID` int(11) NOT NULL,
  `problem_statement` varchar(5000) DEFAULT NULL,
  `op_1` varchar(2500) DEFAULT NULL,
  `op_2` varchar(2500) DEFAULT NULL,
  `op_3` varchar(2500) DEFAULT NULL,
  `op_4` varchar(2500) DEFAULT NULL,
  `answer` int(11) NOT NULL,
  `pos_marks` int(11) NOT NULL,
  `neg_marks` int(11) NOT NULL,
  PRIMARY KEY (`Q_ID`),
  UNIQUE KEY `Q_ID` (`Q_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcq_questions`
--

LOCK TABLES `mcq_questions` WRITE;
/*!40000 ALTER TABLE `mcq_questions` DISABLE KEYS */;
INSERT INTO `mcq_questions` VALUES (1,'Suppose that in a C program snippet, followings statements are used.\ni) sizeof(int);\nii) sizeof(int*);\niii) sizeof(int**);\nAssuming size of pointer is 4 bytes and size of int is also 4 bytes, pick the most correct answer from the given options.','Only i) would compile successfully and it would return size as 4','i), ii) and iii) would compile successfully and size of each would be same i.e. 4','i), ii) and iii) would compile successfully but the size of each would be different and would be decided at run time.','ii) and iii) would result in compile error but i) would compile and result in size as 4.',2,3,3),(2,'Assume int is 4 bytes, char is 1 byte and float is 4 bytes. Also, assume that pointer size is 4 bytes (i.e. typical case)\nchar *pChar;\nint *pInt;\nfloat *pFloat;\nsizeof(pChar);\nsizeof(pInt);\nsizeof(pFloat);\nWhat’s the size returned for each of sizeof() operator?','4 4 4','1 4 4','1 4 8','1 4 6',1,3,3),(3,'Let x be an integer which can take a value of 0 or 1. The statement if(x = =0) x = 1; else x = 0; is equivalent to which one of the following?','X=1+x','X=1-x','X=x-1','X=1%x',2,3,3),(4,'A program attempts to generate as many permutations as possible of the string, \'abcd\' by pushing the characters a, b, c, d in the same order onto a stack, but it may pop off the top character at any time. Which one of the following strings CANNOT be generated using this program?','abcd','cabd','dabc','bacd',2,3,3),(5,'In the context of the following printf() in C, pick the best statement.\ni) printf(\"%d\",8);\nii) printf(\"%d\",090);\niii) printf(\"%d\",00200);\niv) printf(\"%d\",0007000);','Only i) would compile. And it will print 8','Both i) and ii) would compile. i) will print 8 while ii) will print 90','All i), ii), iii) and iv) would compile successfully and they will print 8, 90, 200 & 7000 respectively.','Only i), iii) and iv) would compile successfully. They will print 8, 128 and 3584 respectively',4,3,3),(6,'In the context of modulo operation (i.e. remainder on division) for floating point (say 2.1 and 1.1), pick the best statement','For floating point, modulo operation isn\'t defined and that\'s why modulo can\'t be found.','(2.1 % 1.1) is the result of modulo operation','fmod(2.1,1.1) is the result of module operation.','((int)2.1) % ((int)1.1) is the result of modulo operation',3,3,3),(7,'Which of the given printf statement(s) would be able to print arr[5][5][5]\n(i) printf(\"%d\",arr[5][5][5]);\n(ii) printf(\"%d\",*(*(*(arr+5)+5)+5));\n(iii) printf(\"%d\",(*(*(arr+5)+5))[5]);\n(iv) printf(\"%d\",*((*(arr+5))[5]+5));','only (i) would compile and print 123','only (i), (ii) and (iii) would compile but only (i) and (ii) would print 123','all (i), (ii), (iii) and (iv) would compile but only (i) and (ii) would print 123','all (i), (ii), (iii) and (iv) would compile and all would print 123.',4,3,3),(8,'For a given integer, which of the following operators can be used to “set” and “reset” a particular bit respectively?','| and &','&& and ||','& and |','|| and &&',1,3,3),(9,'#include \"stdio.h\"\nint main()\n{\n int a = 10;\n int b = 15;\n printf(\"=%d\",(a+1),(b=a+2));\n printf(\" %d=\",b);\n return 0;\n}',' =11 15=','=11 12=','Compiler Error due to (b=a+2) in the first printf()','No compile error but output would be =11 X= where X would depend on compiler implementation.',2,3,3),(10,'#include \"stdio.h\"\nint main()\n{\n int a = 10;\n printf(\"=%d %d=\",(a+1));\n return 0;\n}','=11 0=','=11 X= where X would depend on Compiler implementation','Undefined behaviour','Compiler Error due to missing argument for second %d',3,3,3),(11,'Which of the following functions from “stdio.h” can be used in place of printf()?','fputs() with FILE stream as stdout','fprintf() with FILE stream as stdout','fwrite() with FILE stream as stdout','All of the above three - a, b and c.',2,3,3),(12,'As per C language standard, which of the followings is/are not keyword(s)? Pick the best statement. auto make main sizeof elseif','Make main elseif','Make main','Auto make','Sizeof elseif make',1,3,3),(13,'With respect to following “for” loops in C, pick the best statement Assume that there is a prior declaration of \'i\' in all cases\nfor (i < 10; i = 0 ; i++) // (i)\nfor (i < 10; i++ ; i = 0) // (ii)\nfor (i = 0; i < 10 ; i++) // (iii)\nfor (i = 0; i++ ; i < 10) // (iv)\nfor (i++; i = 0 ; i < 10) // (v)\nfor (i++; i < 0 ; i = 10) // (vi)','All the above “for” loops would compile successfully.','All the above “for” loops would compile successfully. Except (iii), the behaviour of all the other “for” loops depend on compiler implementation.','Only (iii) would compile successfully','Only (iii) and (iv) would compile successfully but behaviour of (iv) would depend on compiler implementation.',1,3,3),(14,'#include \"stdio.h\"\nint main()\n{\n  int i = 1, j;\n  for ( ; ; )\n  { \n    if (i)\n        j = --i;\n    if (j < 10)\n       printf(\"CodeBuddies\", j++);\n    else\n       break;\n  }\n  return 0;\n}','Compile Error.','No compile error but it will run into infinite loop printing CodeBuddies','No compile error and it’ll print CodeBuddies 10 times','No compile error but it’ll print CodeBuddies 9 times',3,3,3),(15,'#include \"stdio.h\"\nint main()\n{\n int j = 0;\n for ( ; j < 10 ; )\n { \n   if (j < 10)\n     printf(\"Code\", j++);\n   else\n     continue;\n   printf(“Buddies”);\n }\n return 0;\n}','Compile Error due to use of continue in for loop','No compile error but it will run into infinite loop printing Code','No compile error and it’ll print CodeBuddies 10 times followed by Buddies once','No compile error and it’ll print CodeBuddies 10 times',4,3,3),(16,'/*Program Snippet 1 with for loop*/\nfor (i = 0; i < 10; i++)\n{\n   /*statement1*/\n   continue;\n   /*statement2*/\n}\n/*Program Snippet 2 with while loop*/\ni = 0;\nwhile (i < 10)\n{\n   /*statement1*/\n   continue;\n   /*statement2*/\n   i++;\n}\n/*Program Snippet 3 with do-while loop*/\ni = 0;\ndo\n{\n   /*statement1*/\n   continue;\n   /*statement2*/\n   i++;\n}while (i < 10);','All the loops are equivalent i.e. any of the three can be chosen and they all will perform exactly same.','continue can\'t be used with all the three loops in C','After hitting the continue; statement in all the loops, the next expression to be executed would be controlling expression (i.e. i < 10) in all the 3 loops','None of the above is correct',4,3,3),(17,'switch (controlling_expression)\n{\n  case label1:\n    /*label1 statements*/\n    break;\n  case label2:\n    /*label1 statements*/\n    break;\n  default:\n    /*Default statements*/\n}\n','“switch” body may not have any “case” label at all and it would still compile','“switch” body may not have the “default” label and it would still compile','“switch” body may contain more than one “case” labels where the label value of these “case” is same and it would still compile. If “switch” controlling expression results in this “case” label value, the “case” which is placed first would be executed','“switch” body can have the “default” label at first i.e. before all the other “case” labels. It would still compile',3,3,3),(18,'Assuming int size is 4 bytes, what is going to happen when we compile and run the following program?\n#include “stdio.h”\nint main()\n{\n  printf(“CodeBuddies\\n”);\n  main();\n  return 0;\n}','CodeBuddies would be printed only once. Because when main() is used inside main(), it’s ignored by compiler at run time. This is to make sure that main() is called only once','CodeBuddies would be printed in 2147483647 times i.e. (2 to the power 31) - 1.','It’ll print CodeBuddies infinite times i.e. the program will continue to run forever until it’s terminated by other means such as CTRL+C or CTRL+Z etc','CodeBuddies would be printed until stack overflow happens for this program',4,3,3),(19,'In a C program, following variables are defined:\nfloat      x = 2.17;\ndouble   y = 2.17;\nlong double z = 2.17;','printf(\"%f %lf %Lf\",x,y,z);','printf(“%f %f %f”,x,y,z);','printf(\"%f %ff %fff\",x,y,z);','printf(\"%f %lf %llf\",x,y,z);',1,3,3),(20,'“typedef” in C basically works as an alias. Which of the following is correct for “typedef”?','typedef can be used to alias compound data types such as struct and union.','typedef can be used to alias both compound data types and pointer to these compound types.','typedef can be used to alias a function pointer','All of the above',4,3,3),(21,'Suppose a, b, c and d are int variables. For ternary operator in C ( ? : ), pick the best statement','a>b ? : ; is valid statement i.e. 2nd and 3rd operands can be empty and they are implicitly replaced with non-zero value at run-time','a>b ? c=10 : d=10; is valid statement. Based on the value of a and b, either c or d gets assigned the value of 10.','a>b ? (c=10,d=20) : (c=20,d=10); is valid statement. Based on the value of a and b, either c=10,d=20 gets executed or c=20,d=10 gets executed','All of the above are valid statements for ternary operator.',3,3,3),(22,'Which of the followings is correct for a function definition along with storage-class specifier in C language?','int fun(auto int arg)','int fun(static int arg)','int fun(register int arg)','int fun(extern int arg) int fun(extern int arg)',3,3,3),(23,'Pick the correct statement for const and volatile.','const is the opposite of volatile and vice versa.','const and volatile can’t be used for struct and union. ','const and volatile can’t be used for typedef or enum','const and volatile are independent i.e. it’s possible that a variable is defined as both const and volatile.',4,3,3),(24,'In the below statement, ptr1 and ptr2 are uninitialized pointers to int i.e. they are pointing to some random address that may or may not be valid address.\nint* ptr1, ptr2;','true','false','','',2,3,3),(25,'Anyone of the followings can be used to declare a node for a singly linked list. If we use the first declaration, “struct node * nodePtr;” would be used to declare pointer to a node. If we use the second declaration, “NODEPTR nodePtr;” can be used to declare pointer to a node.\n/* First declaration */\nstruct node {\nint data;\nstruct node * nextPtr;\n};\n \n/* Second declaration */\ntypedef struct node{\nint data;\nNODEPTR nextPtr;\n} * NODEPTR;\n','true','false','','',2,3,3),(26,'Anyone of the following can be used to declare a node for a singly linked list and “NODEPTR nodePtr;” can be used to declare pointer to a node using any of the following\n/* First declaration */\ntypedef struct node\n{\n int data;\n struct node *nextPtr;\n}* NODEPTR;\n \n/* Second declaration */\nstruct node\n{\n int data;\n struct node * nextPtr;\n};\ntypedef struct node * NODEPTR;','true','false','','',1,3,3),(27,'In a C file (say sourcefile1.c), an array is defined as follows. Here, we don’t need to mention arrary arr size explicitly in [] because the size would be determined by the number of elements used in the initialization.\nint arr[] = {1,2,3,4,5};\nIn another C file (say sourcefile2.c), the same array is declared for usage as follows:\nextern int arr[];\nIn sourcefile2.c, we can use sizeof() on arr to find out the actual size of arr','true','false','','',2,3,3),(28,'#include \"stdio.h\"\nint foo(int a)\n{\n printf(\"%d\",a);\n return 0;\n}\nint main()\n{\n foo;\n return 0;\n}','It’ll result in compile error because foo is used without parentheses','No compile error and some garbage value would be passed to foo function. This would make foo to be executed with output “garbage integer”','No compile error but foo function wouldn’t be executed. The program wouldn\'t print anything','No compile error and ZERO (i.e. 0) would be passed to foo function. This would make foo to be executed with output 0',3,3,3),(29,'#include \"stdio.h\"\nint * arrPtr[5];\nint main()\n{\n if(*(arrPtr+2) == *(arrPtr+4))\n {\n   printf(\"Equal!\");\n }\n else\n {\n  printf(\"Not Equal\");\n }\n return 0;\n}','Compile Error','It’ll always print Equal','It’ll always print Not Equal','Since elements of arrPtr aren’t initialized in the program, it’ll print either Equal or Not Equal',2,3,3),(30,'Typically, library header files in C (e.g. stdio.h) contain not only declaration of functions and macro definitions but they contain definition of user defined data types (e.g. struct, union etc), typedefs and definition of global variables as well. So if we include the same header file more than once in a C program, it would result in compile issue because re-definition of many of the constructs of the header file would happen. So it means the following program will give compile error.\n#include “stdio.h”\n#include “stdio.h”\n#include “stdio.h”\nint main()\n{\n printf(“Whether this statement would be printed?”)\n return 0;\n}','true','false','','',2,3,3);
/*!40000 ALTER TABLE `mcq_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `round2_team_summary`
--

DROP TABLE IF EXISTS `round2_team_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `round2_team_summary` (
  `team_name` varchar(100) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `remaining_time` int(11) NOT NULL DEFAULT '0',
  UNIQUE KEY `team_name` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `round2_team_summary`
--

LOCK TABLES `round2_team_summary` WRITE;
/*!40000 ALTER TABLE `round2_team_summary` DISABLE KEYS */;
INSERT INTO `round2_team_summary` VALUES ('ABCD',-27,2405);
/*!40000 ALTER TABLE `round2_team_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `round3_team_summary_template`
--

DROP TABLE IF EXISTS `round3_team_summary_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `round3_team_summary_template` (
  `Q_ID` int(11) NOT NULL,
  `success_rate` float NOT NULL DEFAULT '0',
  UNIQUE KEY `Q_ID` (`Q_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `round3_team_summary_template`
--

LOCK TABLES `round3_team_summary_template` WRITE;
/*!40000 ALTER TABLE `round3_team_summary_template` DISABLE KEYS */;
INSERT INTO `round3_team_summary_template` VALUES (1,0),(2,0),(3,0);
/*!40000 ALTER TABLE `round3_team_summary_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `team_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `college` varchar(100) NOT NULL,
  `part_1` varchar(100) NOT NULL,
  `part_2` varchar(100) NOT NULL,
  `phno` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`team_name`),
  UNIQUE KEY `team_name` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES ('a','a','a','a','a','1','1'),('ABCD','Pranav','VIIT','Pranav','Anirudh','7507330473','pranav.acharekar@gmail.com'),('b','a','a','a','a','2','2'),('c','a','a','a','a','3','3'),('d','a','a','a','a','4','4'),('e','a','a','a','a','5','5'),('f','a','a','a','a','6','6'),('g','a','a','a','a','7','7'),('h','a','a','a','a','8','8');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-01 12:45:50
