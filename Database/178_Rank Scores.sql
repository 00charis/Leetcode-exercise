-- use function dense_rank()
SELECT s.Score, 
DENSE_RANK() OVER (ORDER BY s.Score DESC) AS Rank
 FROM Scores AS s
 ORDER BY RANK
 


 