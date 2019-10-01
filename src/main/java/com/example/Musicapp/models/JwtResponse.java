package com.example.Musicapp.models;

    public class JwtResponse {

        private String jwt;

        public JwtResponse(String jwt) {
            this.jwt = jwt;
        }

        public String getToken() {
            return this.jwt;
        }
    }
