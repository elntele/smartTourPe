# Limpar containers
docker ps -a -q | ForEach-Object { docker stop $_ }
docker ps -a -q | ForEach-Object { docker rm $_ }

# Limpar redes
docker network ls | Where-Object { $_.Name -notlike "bridge" -and $_.Name -notlike "host" -and $_.Name -notlike "none" } | ForEach-Object { docker network rm $_.Id }

# Limpar volumes
docker volume ls -q | ForEach-Object { docker volume rm $_ }

# Limpar imagens
docker images -q | ForEach-Object { docker rmi -f $_ }

# Limpar caches
docker builder prune -af

#remover os orfans da rede
docker-compose down -v --remove-orphans --rmi all



