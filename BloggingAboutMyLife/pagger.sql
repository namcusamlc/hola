SELECT [id]
      ,c.[categoryId]
      ,c.categoryName
      ,[title]
      ,[imagePath]
      ,[logoPath]
      ,[itemContent]
      ,[publishedDate]
  FROM 
  (SELECT ROW_NUMBER() OVER (ORDER BY publishedDate desc) as MyRowNumber, * FROM Item) tblItem
  INNER JOIN Category as c ON tblItem.categoryId = c.categoryId
  WHERE MyRowNumber BETWEEN (((2-1)*3)+1) AND 2*3
GO


