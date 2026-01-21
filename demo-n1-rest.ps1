# REST N+1 Simulation
# 1. Fetch List of Movies
# 2. For each movie, Fetch Actors (Simulating a frontend iterating over the list)

$baseUrl = "http://localhost:8080/api/v1/movies"

Write-Host ">>> [CLIENT] Fetching Movie List..." -ForegroundColor Cyan
$movies = Invoke-RestMethod -Uri $baseUrl -Method Get

foreach ($movie in $movies) {
    $id = $movie.id
    $title = $movie.title
    Write-Host ">>> [CLIENT] Fetching Actors for Movie: $title ($id)" -ForegroundColor Yellow
    $actors = Invoke-RestMethod -Uri "$baseUrl/$id/actors" -Method Get
}

Write-Host ">>> [CLIENT] DONE. Check Broker/Backend logs for Request Count." -ForegroundColor Green
