package com.neilalexander.jnacl.crypto.auth;

public class crypto_hashblocks_sha256 {

  private static int[] round = new int[] {
       0x428a2f98 , 0x71374491 , 0xb5c0fbcf , 0xe9b5dba5
     , 0x3956c25b , 0x59f111f1 , 0x923f82a4 , 0xab1c5ed5
     , 0xd807aa98 , 0x12835b01 , 0x243185be , 0x550c7dc3
     , 0x72be5d74 , 0x80deb1fe , 0x9bdc06a7 , 0xc19bf174
     , 0xe49b69c1 , 0xefbe4786 , 0x0fc19dc6 , 0x240ca1cc
     , 0x2de92c6f , 0x4a7484aa , 0x5cb0a9dc , 0x76f988da
     , 0x983e5152 , 0xa831c66d , 0xb00327c8 , 0xbf597fc7
     , 0xc6e00bf3 , 0xd5a79147 , 0x06ca6351 , 0x14292967
     , 0x27b70a85 , 0x2e1b2138 , 0x4d2c6dfc , 0x53380d13
     , 0x650a7354 , 0x766a0abb , 0x81c2c92e , 0x92722c85
     , 0xa2bfe8a1 , 0xa81a664b , 0xc24b8b70 , 0xc76c51a3
     , 0xd192e819 , 0xd6990624 , 0xf40e3585 , 0x106aa070
     , 0x19a4c116 , 0x1e376c08 , 0x2748774c , 0x34b0bcb5
     , 0x391c0cb3 , 0x4ed8aa4a , 0x5b9cca4f , 0x682e6ff3
     , 0x748f82ee , 0x78a5636f , 0x84c87814 , 0x8cc70208
     , 0x90befffa , 0xa4506ceb , 0xbef9a3f7 , 0xc67178f2
  } ;
  
  private static int load_bigendian(byte[] x, int offset) {
    return  (int)(x[3+offset])&0xff
        | (((int)(x[2+offset])&0xff) << 8)
        | (((int)(x[1+offset])&0xff) << 16)
        | (((int)(x[0+offset])&0xff) << 24);
  }

  private static void store_bigendian(byte[] x, int offset, int u) {
    x[0+offset] = (byte) u; u >>>= 8;
    x[1+offset] = (byte) u; u >>>= 8;
    x[2+offset] = (byte) u; u >>>= 8;
    x[3+offset] = (byte) u;
  }

  public static int crypto_hashblocks(byte[] statebytes, byte[] in, int offset, int inlen) {
    int[] state = new int[8];

    int r0 = load_bigendian(statebytes ,  0); state[0] = r0;
    int r1 = load_bigendian(statebytes ,  4); state[1] = r1;
    int r2 = load_bigendian(statebytes ,  8); state[2] = r2;
    int r3 = load_bigendian(statebytes , 12); state[3] = r3;
    int r4 = load_bigendian(statebytes , 16); state[4] = r4;
    int r5 = load_bigendian(statebytes , 20); state[5] = r5;
    int r6 = load_bigendian(statebytes , 24); state[6] = r6;
    int r7 = load_bigendian(statebytes , 28); state[7] = r7;

    int inIdx = 0;
    while (inlen >= 64) {
      int w0  = load_bigendian(in , offset + inIdx +  0);
      int w1  = load_bigendian(in , offset + inIdx +  4);
      int w2  = load_bigendian(in , offset + inIdx +  8);
      int w3  = load_bigendian(in , offset + inIdx + 12);
      int w4  = load_bigendian(in , offset + inIdx + 16);
      int w5  = load_bigendian(in , offset + inIdx + 20);
      int w6  = load_bigendian(in , offset + inIdx + 24);
      int w7  = load_bigendian(in , offset + inIdx + 28);
      int w8  = load_bigendian(in , offset + inIdx + 32);
      int w9  = load_bigendian(in , offset + inIdx + 36);
      int w10 = load_bigendian(in , offset + inIdx + 40);
      int w11 = load_bigendian(in , offset + inIdx + 44);
      int w12 = load_bigendian(in , offset + inIdx + 48);
      int w13 = load_bigendian(in , offset + inIdx + 52);
      int w14 = load_bigendian(in , offset + inIdx + 56);
      int w15 = load_bigendian(in , offset + inIdx + 60);

      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[0 + 0] + w0;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[0 + 1] + w1;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[0 + 2] + w2;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[0 + 3] + w3;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[0 + 4] + w4;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[0 + 5] + w5;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[0 + 6] + w6;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[0 + 7] + w7;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));
      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[0 + 8] + w8;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[0 + 9] + w9;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[0 + 10] + w10;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[0 + 11] + w11;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[0 + 12] + w12;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[0 + 13] + w13;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[0 + 14] + w14;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[0 + 15] + w15;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));


      w0 += ((((w14) >> (17)) | ((w14) << (32 - (17)))) ^ (((w14) >> (19)) | ((w14) << (32 - (19)))) ^ ((w14) >> (10))) + w9 + ((((w1) >> (7)) | ((w1) << (32 - (7)))) ^ (((w1) >> (18)) | ((w1) << (32 - (18)))) ^ ((w1) >> (3)));
      w1 += ((((w15) >> (17)) | ((w15) << (32 - (17)))) ^ (((w15) >> (19)) | ((w15) << (32 - (19)))) ^ ((w15) >> (10))) + w10 + ((((w2) >> (7)) | ((w2) << (32 - (7)))) ^ (((w2) >> (18)) | ((w2) << (32 - (18)))) ^ ((w2) >> (3)));
      w2 += ((((w0) >> (17)) | ((w0) << (32 - (17)))) ^ (((w0) >> (19)) | ((w0) << (32 - (19)))) ^ ((w0) >> (10))) + w11 + ((((w3) >> (7)) | ((w3) << (32 - (7)))) ^ (((w3) >> (18)) | ((w3) << (32 - (18)))) ^ ((w3) >> (3)));
      w3 += ((((w1) >> (17)) | ((w1) << (32 - (17)))) ^ (((w1) >> (19)) | ((w1) << (32 - (19)))) ^ ((w1) >> (10))) + w12 + ((((w4) >> (7)) | ((w4) << (32 - (7)))) ^ (((w4) >> (18)) | ((w4) << (32 - (18)))) ^ ((w4) >> (3)));
      w4 += ((((w2) >> (17)) | ((w2) << (32 - (17)))) ^ (((w2) >> (19)) | ((w2) << (32 - (19)))) ^ ((w2) >> (10))) + w13 + ((((w5) >> (7)) | ((w5) << (32 - (7)))) ^ (((w5) >> (18)) | ((w5) << (32 - (18)))) ^ ((w5) >> (3)));
      w5 += ((((w3) >> (17)) | ((w3) << (32 - (17)))) ^ (((w3) >> (19)) | ((w3) << (32 - (19)))) ^ ((w3) >> (10))) + w14 + ((((w6) >> (7)) | ((w6) << (32 - (7)))) ^ (((w6) >> (18)) | ((w6) << (32 - (18)))) ^ ((w6) >> (3)));
      w6 += ((((w4) >> (17)) | ((w4) << (32 - (17)))) ^ (((w4) >> (19)) | ((w4) << (32 - (19)))) ^ ((w4) >> (10))) + w15 + ((((w7) >> (7)) | ((w7) << (32 - (7)))) ^ (((w7) >> (18)) | ((w7) << (32 - (18)))) ^ ((w7) >> (3)));
      w7 += ((((w5) >> (17)) | ((w5) << (32 - (17)))) ^ (((w5) >> (19)) | ((w5) << (32 - (19)))) ^ ((w5) >> (10))) + w0 + ((((w8) >> (7)) | ((w8) << (32 - (7)))) ^ (((w8) >> (18)) | ((w8) << (32 - (18)))) ^ ((w8) >> (3)));
      w8 += ((((w6) >> (17)) | ((w6) << (32 - (17)))) ^ (((w6) >> (19)) | ((w6) << (32 - (19)))) ^ ((w6) >> (10))) + w1 + ((((w9) >> (7)) | ((w9) << (32 - (7)))) ^ (((w9) >> (18)) | ((w9) << (32 - (18)))) ^ ((w9) >> (3)));
      w9 += ((((w7) >> (17)) | ((w7) << (32 - (17)))) ^ (((w7) >> (19)) | ((w7) << (32 - (19)))) ^ ((w7) >> (10))) + w2 + ((((w10) >> (7)) | ((w10) << (32 - (7)))) ^ (((w10) >> (18)) | ((w10) << (32 - (18)))) ^ ((w10) >> (3)));
      w10 += ((((w8) >> (17)) | ((w8) << (32 - (17)))) ^ (((w8) >> (19)) | ((w8) << (32 - (19)))) ^ ((w8) >> (10))) + w3 + ((((w11) >> (7)) | ((w11) << (32 - (7)))) ^ (((w11) >> (18)) | ((w11) << (32 - (18)))) ^ ((w11) >> (3)));
      w11 += ((((w9) >> (17)) | ((w9) << (32 - (17)))) ^ (((w9) >> (19)) | ((w9) << (32 - (19)))) ^ ((w9) >> (10))) + w4 + ((((w12) >> (7)) | ((w12) << (32 - (7)))) ^ (((w12) >> (18)) | ((w12) << (32 - (18)))) ^ ((w12) >> (3)));
      w12 += ((((w10) >> (17)) | ((w10) << (32 - (17)))) ^ (((w10) >> (19)) | ((w10) << (32 - (19)))) ^ ((w10) >> (10))) + w5 + ((((w13) >> (7)) | ((w13) << (32 - (7)))) ^ (((w13) >> (18)) | ((w13) << (32 - (18)))) ^ ((w13) >> (3)));
      w13 += ((((w11) >> (17)) | ((w11) << (32 - (17)))) ^ (((w11) >> (19)) | ((w11) << (32 - (19)))) ^ ((w11) >> (10))) + w6 + ((((w14) >> (7)) | ((w14) << (32 - (7)))) ^ (((w14) >> (18)) | ((w14) << (32 - (18)))) ^ ((w14) >> (3)));
      w14 += ((((w12) >> (17)) | ((w12) << (32 - (17)))) ^ (((w12) >> (19)) | ((w12) << (32 - (19)))) ^ ((w12) >> (10))) + w7 + ((((w15) >> (7)) | ((w15) << (32 - (7)))) ^ (((w15) >> (18)) | ((w15) << (32 - (18)))) ^ ((w15) >> (3)));
      w15 += ((((w13) >> (17)) | ((w13) << (32 - (17)))) ^ (((w13) >> (19)) | ((w13) << (32 - (19)))) ^ ((w13) >> (10))) + w8 + ((((w0) >> (7)) | ((w0) << (32 - (7)))) ^ (((w0) >> (18)) | ((w0) << (32 - (18)))) ^ ((w0) >> (3)));


      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[16 + 0] + w0;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[16 + 1] + w1;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[16 + 2] + w2;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[16 + 3] + w3;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[16 + 4] + w4;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[16 + 5] + w5;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[16 + 6] + w6;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[16 + 7] + w7;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));
      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[16 + 8] + w8;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[16 + 9] + w9;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[16 + 10] + w10;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[16 + 11] + w11;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[16 + 12] + w12;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[16 + 13] + w13;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[16 + 14] + w14;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[16 + 15] + w15;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));


      w0 += ((((w14) >> (17)) | ((w14) << (32 - (17)))) ^ (((w14) >> (19)) | ((w14) << (32 - (19)))) ^ ((w14) >> (10))) + w9 + ((((w1) >> (7)) | ((w1) << (32 - (7)))) ^ (((w1) >> (18)) | ((w1) << (32 - (18)))) ^ ((w1) >> (3)));
      w1 += ((((w15) >> (17)) | ((w15) << (32 - (17)))) ^ (((w15) >> (19)) | ((w15) << (32 - (19)))) ^ ((w15) >> (10))) + w10 + ((((w2) >> (7)) | ((w2) << (32 - (7)))) ^ (((w2) >> (18)) | ((w2) << (32 - (18)))) ^ ((w2) >> (3)));
      w2 += ((((w0) >> (17)) | ((w0) << (32 - (17)))) ^ (((w0) >> (19)) | ((w0) << (32 - (19)))) ^ ((w0) >> (10))) + w11 + ((((w3) >> (7)) | ((w3) << (32 - (7)))) ^ (((w3) >> (18)) | ((w3) << (32 - (18)))) ^ ((w3) >> (3)));
      w3 += ((((w1) >> (17)) | ((w1) << (32 - (17)))) ^ (((w1) >> (19)) | ((w1) << (32 - (19)))) ^ ((w1) >> (10))) + w12 + ((((w4) >> (7)) | ((w4) << (32 - (7)))) ^ (((w4) >> (18)) | ((w4) << (32 - (18)))) ^ ((w4) >> (3)));
      w4 += ((((w2) >> (17)) | ((w2) << (32 - (17)))) ^ (((w2) >> (19)) | ((w2) << (32 - (19)))) ^ ((w2) >> (10))) + w13 + ((((w5) >> (7)) | ((w5) << (32 - (7)))) ^ (((w5) >> (18)) | ((w5) << (32 - (18)))) ^ ((w5) >> (3)));
      w5 += ((((w3) >> (17)) | ((w3) << (32 - (17)))) ^ (((w3) >> (19)) | ((w3) << (32 - (19)))) ^ ((w3) >> (10))) + w14 + ((((w6) >> (7)) | ((w6) << (32 - (7)))) ^ (((w6) >> (18)) | ((w6) << (32 - (18)))) ^ ((w6) >> (3)));
      w6 += ((((w4) >> (17)) | ((w4) << (32 - (17)))) ^ (((w4) >> (19)) | ((w4) << (32 - (19)))) ^ ((w4) >> (10))) + w15 + ((((w7) >> (7)) | ((w7) << (32 - (7)))) ^ (((w7) >> (18)) | ((w7) << (32 - (18)))) ^ ((w7) >> (3)));
      w7 += ((((w5) >> (17)) | ((w5) << (32 - (17)))) ^ (((w5) >> (19)) | ((w5) << (32 - (19)))) ^ ((w5) >> (10))) + w0 + ((((w8) >> (7)) | ((w8) << (32 - (7)))) ^ (((w8) >> (18)) | ((w8) << (32 - (18)))) ^ ((w8) >> (3)));
      w8 += ((((w6) >> (17)) | ((w6) << (32 - (17)))) ^ (((w6) >> (19)) | ((w6) << (32 - (19)))) ^ ((w6) >> (10))) + w1 + ((((w9) >> (7)) | ((w9) << (32 - (7)))) ^ (((w9) >> (18)) | ((w9) << (32 - (18)))) ^ ((w9) >> (3)));
      w9 += ((((w7) >> (17)) | ((w7) << (32 - (17)))) ^ (((w7) >> (19)) | ((w7) << (32 - (19)))) ^ ((w7) >> (10))) + w2 + ((((w10) >> (7)) | ((w10) << (32 - (7)))) ^ (((w10) >> (18)) | ((w10) << (32 - (18)))) ^ ((w10) >> (3)));
      w10 += ((((w8) >> (17)) | ((w8) << (32 - (17)))) ^ (((w8) >> (19)) | ((w8) << (32 - (19)))) ^ ((w8) >> (10))) + w3 + ((((w11) >> (7)) | ((w11) << (32 - (7)))) ^ (((w11) >> (18)) | ((w11) << (32 - (18)))) ^ ((w11) >> (3)));
      w11 += ((((w9) >> (17)) | ((w9) << (32 - (17)))) ^ (((w9) >> (19)) | ((w9) << (32 - (19)))) ^ ((w9) >> (10))) + w4 + ((((w12) >> (7)) | ((w12) << (32 - (7)))) ^ (((w12) >> (18)) | ((w12) << (32 - (18)))) ^ ((w12) >> (3)));
      w12 += ((((w10) >> (17)) | ((w10) << (32 - (17)))) ^ (((w10) >> (19)) | ((w10) << (32 - (19)))) ^ ((w10) >> (10))) + w5 + ((((w13) >> (7)) | ((w13) << (32 - (7)))) ^ (((w13) >> (18)) | ((w13) << (32 - (18)))) ^ ((w13) >> (3)));
      w13 += ((((w11) >> (17)) | ((w11) << (32 - (17)))) ^ (((w11) >> (19)) | ((w11) << (32 - (19)))) ^ ((w11) >> (10))) + w6 + ((((w14) >> (7)) | ((w14) << (32 - (7)))) ^ (((w14) >> (18)) | ((w14) << (32 - (18)))) ^ ((w14) >> (3)));
      w14 += ((((w12) >> (17)) | ((w12) << (32 - (17)))) ^ (((w12) >> (19)) | ((w12) << (32 - (19)))) ^ ((w12) >> (10))) + w7 + ((((w15) >> (7)) | ((w15) << (32 - (7)))) ^ (((w15) >> (18)) | ((w15) << (32 - (18)))) ^ ((w15) >> (3)));
      w15 += ((((w13) >> (17)) | ((w13) << (32 - (17)))) ^ (((w13) >> (19)) | ((w13) << (32 - (19)))) ^ ((w13) >> (10))) + w8 + ((((w0) >> (7)) | ((w0) << (32 - (7)))) ^ (((w0) >> (18)) | ((w0) << (32 - (18)))) ^ ((w0) >> (3)));


      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[32 + 0] + w0;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[32 + 1] + w1;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[32 + 2] + w2;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[32 + 3] + w3;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[32 + 4] + w4;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[32 + 5] + w5;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[32 + 6] + w6;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[32 + 7] + w7;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));
      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[32 + 8] + w8;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[32 + 9] + w9;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[32 + 10] + w10;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[32 + 11] + w11;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[32 + 12] + w12;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[32 + 13] + w13;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[32 + 14] + w14;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[32 + 15] + w15;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));


      w0 += ((((w14) >> (17)) | ((w14) << (32 - (17)))) ^ (((w14) >> (19)) | ((w14) << (32 - (19)))) ^ ((w14) >> (10))) + w9 + ((((w1) >> (7)) | ((w1) << (32 - (7)))) ^ (((w1) >> (18)) | ((w1) << (32 - (18)))) ^ ((w1) >> (3)));
      w1 += ((((w15) >> (17)) | ((w15) << (32 - (17)))) ^ (((w15) >> (19)) | ((w15) << (32 - (19)))) ^ ((w15) >> (10))) + w10 + ((((w2) >> (7)) | ((w2) << (32 - (7)))) ^ (((w2) >> (18)) | ((w2) << (32 - (18)))) ^ ((w2) >> (3)));
      w2 += ((((w0) >> (17)) | ((w0) << (32 - (17)))) ^ (((w0) >> (19)) | ((w0) << (32 - (19)))) ^ ((w0) >> (10))) + w11 + ((((w3) >> (7)) | ((w3) << (32 - (7)))) ^ (((w3) >> (18)) | ((w3) << (32 - (18)))) ^ ((w3) >> (3)));
      w3 += ((((w1) >> (17)) | ((w1) << (32 - (17)))) ^ (((w1) >> (19)) | ((w1) << (32 - (19)))) ^ ((w1) >> (10))) + w12 + ((((w4) >> (7)) | ((w4) << (32 - (7)))) ^ (((w4) >> (18)) | ((w4) << (32 - (18)))) ^ ((w4) >> (3)));
      w4 += ((((w2) >> (17)) | ((w2) << (32 - (17)))) ^ (((w2) >> (19)) | ((w2) << (32 - (19)))) ^ ((w2) >> (10))) + w13 + ((((w5) >> (7)) | ((w5) << (32 - (7)))) ^ (((w5) >> (18)) | ((w5) << (32 - (18)))) ^ ((w5) >> (3)));
      w5 += ((((w3) >> (17)) | ((w3) << (32 - (17)))) ^ (((w3) >> (19)) | ((w3) << (32 - (19)))) ^ ((w3) >> (10))) + w14 + ((((w6) >> (7)) | ((w6) << (32 - (7)))) ^ (((w6) >> (18)) | ((w6) << (32 - (18)))) ^ ((w6) >> (3)));
      w6 += ((((w4) >> (17)) | ((w4) << (32 - (17)))) ^ (((w4) >> (19)) | ((w4) << (32 - (19)))) ^ ((w4) >> (10))) + w15 + ((((w7) >> (7)) | ((w7) << (32 - (7)))) ^ (((w7) >> (18)) | ((w7) << (32 - (18)))) ^ ((w7) >> (3)));
      w7 += ((((w5) >> (17)) | ((w5) << (32 - (17)))) ^ (((w5) >> (19)) | ((w5) << (32 - (19)))) ^ ((w5) >> (10))) + w0 + ((((w8) >> (7)) | ((w8) << (32 - (7)))) ^ (((w8) >> (18)) | ((w8) << (32 - (18)))) ^ ((w8) >> (3)));
      w8 += ((((w6) >> (17)) | ((w6) << (32 - (17)))) ^ (((w6) >> (19)) | ((w6) << (32 - (19)))) ^ ((w6) >> (10))) + w1 + ((((w9) >> (7)) | ((w9) << (32 - (7)))) ^ (((w9) >> (18)) | ((w9) << (32 - (18)))) ^ ((w9) >> (3)));
      w9 += ((((w7) >> (17)) | ((w7) << (32 - (17)))) ^ (((w7) >> (19)) | ((w7) << (32 - (19)))) ^ ((w7) >> (10))) + w2 + ((((w10) >> (7)) | ((w10) << (32 - (7)))) ^ (((w10) >> (18)) | ((w10) << (32 - (18)))) ^ ((w10) >> (3)));
      w10 += ((((w8) >> (17)) | ((w8) << (32 - (17)))) ^ (((w8) >> (19)) | ((w8) << (32 - (19)))) ^ ((w8) >> (10))) + w3 + ((((w11) >> (7)) | ((w11) << (32 - (7)))) ^ (((w11) >> (18)) | ((w11) << (32 - (18)))) ^ ((w11) >> (3)));
      w11 += ((((w9) >> (17)) | ((w9) << (32 - (17)))) ^ (((w9) >> (19)) | ((w9) << (32 - (19)))) ^ ((w9) >> (10))) + w4 + ((((w12) >> (7)) | ((w12) << (32 - (7)))) ^ (((w12) >> (18)) | ((w12) << (32 - (18)))) ^ ((w12) >> (3)));
      w12 += ((((w10) >> (17)) | ((w10) << (32 - (17)))) ^ (((w10) >> (19)) | ((w10) << (32 - (19)))) ^ ((w10) >> (10))) + w5 + ((((w13) >> (7)) | ((w13) << (32 - (7)))) ^ (((w13) >> (18)) | ((w13) << (32 - (18)))) ^ ((w13) >> (3)));
      w13 += ((((w11) >> (17)) | ((w11) << (32 - (17)))) ^ (((w11) >> (19)) | ((w11) << (32 - (19)))) ^ ((w11) >> (10))) + w6 + ((((w14) >> (7)) | ((w14) << (32 - (7)))) ^ (((w14) >> (18)) | ((w14) << (32 - (18)))) ^ ((w14) >> (3)));
      w14 += ((((w12) >> (17)) | ((w12) << (32 - (17)))) ^ (((w12) >> (19)) | ((w12) << (32 - (19)))) ^ ((w12) >> (10))) + w7 + ((((w15) >> (7)) | ((w15) << (32 - (7)))) ^ (((w15) >> (18)) | ((w15) << (32 - (18)))) ^ ((w15) >> (3)));
      w15 += ((((w13) >> (17)) | ((w13) << (32 - (17)))) ^ (((w13) >> (19)) | ((w13) << (32 - (19)))) ^ ((w13) >> (10))) + w8 + ((((w0) >> (7)) | ((w0) << (32 - (7)))) ^ (((w0) >> (18)) | ((w0) << (32 - (18)))) ^ ((w0) >> (3)));


      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[48 + 0] + w0;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[48 + 1] + w1;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[48 + 2] + w2;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[48 + 3] + w3;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[48 + 4] + w4;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[48 + 5] + w5;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[48 + 6] + w6;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[48 + 7] + w7;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));
      r7 += ((((r4) >> (6)) | ((r4) << (32 - (6)))) ^ (((r4) >> (11)) | ((r4) << (32 - (11)))) ^ (((r4) >> (25)) | ((r4) << (32 - (25))))) + ((r4 & r5) ^ (~r4 & r6)) + round[48 + 8] + w8;
      r3 += r7;
      r7 += ((((r0) >> (2)) | ((r0) << (32 - (2)))) ^ (((r0) >> (13)) | ((r0) << (32 - (13)))) ^ (((r0) >> (22)) | ((r0) << (32 - (22))))) + ((r0 & r1) ^ (r0 & r2) ^ (r1 & r2));
      r6 += ((((r3) >> (6)) | ((r3) << (32 - (6)))) ^ (((r3) >> (11)) | ((r3) << (32 - (11)))) ^ (((r3) >> (25)) | ((r3) << (32 - (25))))) + ((r3 & r4) ^ (~r3 & r5)) + round[48 + 9] + w9;
      r2 += r6;
      r6 += ((((r7) >> (2)) | ((r7) << (32 - (2)))) ^ (((r7) >> (13)) | ((r7) << (32 - (13)))) ^ (((r7) >> (22)) | ((r7) << (32 - (22))))) + ((r7 & r0) ^ (r7 & r1) ^ (r0 & r1));
      r5 += ((((r2) >> (6)) | ((r2) << (32 - (6)))) ^ (((r2) >> (11)) | ((r2) << (32 - (11)))) ^ (((r2) >> (25)) | ((r2) << (32 - (25))))) + ((r2 & r3) ^ (~r2 & r4)) + round[48 + 10] + w10;
      r1 += r5;
      r5 += ((((r6) >> (2)) | ((r6) << (32 - (2)))) ^ (((r6) >> (13)) | ((r6) << (32 - (13)))) ^ (((r6) >> (22)) | ((r6) << (32 - (22))))) + ((r6 & r7) ^ (r6 & r0) ^ (r7 & r0));
      r4 += ((((r1) >> (6)) | ((r1) << (32 - (6)))) ^ (((r1) >> (11)) | ((r1) << (32 - (11)))) ^ (((r1) >> (25)) | ((r1) << (32 - (25))))) + ((r1 & r2) ^ (~r1 & r3)) + round[48 + 11] + w11;
      r0 += r4;
      r4 += ((((r5) >> (2)) | ((r5) << (32 - (2)))) ^ (((r5) >> (13)) | ((r5) << (32 - (13)))) ^ (((r5) >> (22)) | ((r5) << (32 - (22))))) + ((r5 & r6) ^ (r5 & r7) ^ (r6 & r7));
      r3 += ((((r0) >> (6)) | ((r0) << (32 - (6)))) ^ (((r0) >> (11)) | ((r0) << (32 - (11)))) ^ (((r0) >> (25)) | ((r0) << (32 - (25))))) + ((r0 & r1) ^ (~r0 & r2)) + round[48 + 12] + w12;
      r7 += r3;
      r3 += ((((r4) >> (2)) | ((r4) << (32 - (2)))) ^ (((r4) >> (13)) | ((r4) << (32 - (13)))) ^ (((r4) >> (22)) | ((r4) << (32 - (22))))) + ((r4 & r5) ^ (r4 & r6) ^ (r5 & r6));
      r2 += ((((r7) >> (6)) | ((r7) << (32 - (6)))) ^ (((r7) >> (11)) | ((r7) << (32 - (11)))) ^ (((r7) >> (25)) | ((r7) << (32 - (25))))) + ((r7 & r0) ^ (~r7 & r1)) + round[48 + 13] + w13;
      r6 += r2;
      r2 += ((((r3) >> (2)) | ((r3) << (32 - (2)))) ^ (((r3) >> (13)) | ((r3) << (32 - (13)))) ^ (((r3) >> (22)) | ((r3) << (32 - (22))))) + ((r3 & r4) ^ (r3 & r5) ^ (r4 & r5));
      r1 += ((((r6) >> (6)) | ((r6) << (32 - (6)))) ^ (((r6) >> (11)) | ((r6) << (32 - (11)))) ^ (((r6) >> (25)) | ((r6) << (32 - (25))))) + ((r6 & r7) ^ (~r6 & r0)) + round[48 + 14] + w14;
      r5 += r1;
      r1 += ((((r2) >> (2)) | ((r2) << (32 - (2)))) ^ (((r2) >> (13)) | ((r2) << (32 - (13)))) ^ (((r2) >> (22)) | ((r2) << (32 - (22))))) + ((r2 & r3) ^ (r2 & r4) ^ (r3 & r4));
      r0 += ((((r5) >> (6)) | ((r5) << (32 - (6)))) ^ (((r5) >> (11)) | ((r5) << (32 - (11)))) ^ (((r5) >> (25)) | ((r5) << (32 - (25))))) + ((r5 & r6) ^ (~r5 & r7)) + round[48 + 15] + w15;
      r4 += r0;
      r0 += ((((r1) >> (2)) | ((r1) << (32 - (2)))) ^ (((r1) >> (13)) | ((r1) << (32 - (13)))) ^ (((r1) >> (22)) | ((r1) << (32 - (22))))) + ((r1 & r2) ^ (r1 & r3) ^ (r2 & r3));


      r0 += state[0];
      r1 += state[1];
      r2 += state[2];
      r3 += state[3];
      r4 += state[4];
      r5 += state[5];
      r6 += state[6];
      r7 += state[7];

      state[0] = r0;
      state[1] = r1;
      state[2] = r2;
      state[3] = r3;
      state[4] = r4;
      state[5] = r5;
      state[6] = r6;
      state[7] = r7;

      inIdx += 64;
      inlen -= 64;
    }

    store_bigendian(statebytes ,  0,state[0]);
    store_bigendian(statebytes ,  4,state[1]);
    store_bigendian(statebytes ,  8,state[2]);
    store_bigendian(statebytes , 12,state[3]);
    store_bigendian(statebytes , 16,state[4]);
    store_bigendian(statebytes , 20,state[5]);
    store_bigendian(statebytes , 24,state[6]);
    store_bigendian(statebytes , 28,state[7]);

    return 0;
  }
}