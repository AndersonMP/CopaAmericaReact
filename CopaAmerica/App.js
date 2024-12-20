import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert} from 'react-native';
import { registrarPronostico } from './services/Services'
const PronosticoApp = () => {
  // Estado para los datos de los equipos y el marcador
  const [marcador1, setMarcador1] = useState('');
  const [marcador2, setMarcador2] = useState('');

  // Función para manejar el evento de guardar
  const guardarMarcador = () => {
    console.log('Registrando pronóstico.');
    registrarPronostico({
      score1: marcador1,
      score2: marcador2
    },
      () => {
        Alert.alert('Éxito', 'Pronóstico registrado para Brasil vs Costa Rica.');
        setMarcador1('');
        setMarcador2('');
      });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Pronóstico Deportivo</Text>

      {/* Mostrar el nombre del usuario */}
      <Text style={styles.userName}>Anderson Muñoz</Text>

      {/* Mostrar los equipos */}
      <View style={styles.teamsContainer}>
        <Text style={styles.label}>Equipo 1: Brasil</Text>
        <Text style={styles.label}>Equipo 2: Costa Rica</Text>
      </View>

      {/* Ingreso de los marcadores */}
      <View style={styles.inputContainer}>
        <Text style={styles.label}>Marcador para Brasil:</Text>
        <TextInput
          style={styles.input}
          value={marcador1}
          onChangeText={setMarcador1}
          keyboardType="numeric"
          placeholder="Ingresa el marcador"
        />

        <Text style={styles.label}>Marcador para Costa Rica:</Text>
        <TextInput
          style={styles.input}
          value={marcador2}
          onChangeText={setMarcador2}
          keyboardType="numeric"
          placeholder="Ingresa el marcador"
        />
      </View>

      {/* Botón para guardar */}
      <Button title="Guardar" onPress={guardarMarcador} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
    backgroundColor: '#f9f9f9', // Fondo más suave
  },
  header: {
    fontSize: 26,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 30,
    color: '#333', // Color más oscuro para contraste
  },
  userName: {
    fontSize: 20,
    fontWeight: '500',
    marginBottom: 20,
    color: '#555', // Nombre de usuario con un color sutil
  },
  teamsContainer: {
    marginBottom: 30,
    paddingHorizontal: 20,
    alignItems: 'center',
  },
  label: {
    fontSize: 18,
    marginBottom: 10,
    color: '#444', // Color más suave para las etiquetas
  },
  inputContainer: {
    width: '100%',
    marginBottom: 30,
  },
  input: {
    height: 45,
    borderColor: '#ddd',
    borderWidth: 1,
    borderRadius: 8,
    marginBottom: 15,
    paddingLeft: 10,
    fontSize: 16,
    backgroundColor: '#fff', // Fondo blanco para inputs
  },
});

export default PronosticoApp;
