SELECT [id]
      ,[title]
      ,[imagePath]
      ,[itemContent]
      ,[price]
      ,[date]
  FROM 
  (SELECT ROW_NUMBER() OVER (ORDER BY date desc) as MyRowNumber, * FROM Menu) tblMenu
  WHERE MyRowNumber BETWEEN 1 AND 2
  
GO

SELECT COUNT(*) as Total
FROM Menu


