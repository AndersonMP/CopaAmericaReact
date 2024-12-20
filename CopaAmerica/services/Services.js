export const registrarPronostico = ({ score1, score2 }, fnExito) => {
    const config = {
        method: 'POST',
        body: JSON.stringify({
            user: {
                userId: 1
            },
            match: {
                matchId: 7
            },
            team1: {
                countryCode: 76
            },
            scoreT1: score1,
            team2: {
                countryCode: 188
            },
            scoreT2: score2
        }),
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }

    }

    fetch('http://192.168.1.104:8080/copa-1.0.0/rws/pronostico/registrar', config)
        .then(response => response.json())
        .then(console.log, fnExito());
}