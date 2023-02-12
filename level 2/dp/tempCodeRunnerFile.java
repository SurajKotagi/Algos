if (rem.j >= arr[rem.i]) {
                    if (dp[rem.i - 1][rem.j - arr[rem.i]] == true) {
                        q.add(new Pair(rem.i - 1, rem.j - arr[rem.i], rem.i + " " + rem.psf));
                    }
                }