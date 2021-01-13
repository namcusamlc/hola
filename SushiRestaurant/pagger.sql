SELECT [id]
      ,tblEntry.[categoryId]
      ,c.categoryName
      ,[title]
      ,[imagePath]
      ,[itemContent]
      ,[price]
      ,[shortContent]
  FROM 
  (SELECT ROW_NUMBER() OVER (ORDER BY id asc) as MyRowNumber, * FROM Entry
  WHERE categoryId = 3) as tblEntry
  INNER JOIN Category as c
  ON c.categoryId = tblEntry.categoryId
  WHERE MyRowNumber BETWEEN 1 AND 3
GO

SELECT COUNT(*) as Total
FROM Entry
WHERE categoryId = 2


