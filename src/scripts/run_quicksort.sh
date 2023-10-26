#!/bin/zsh
# src/scripts/run_quicksort.sh

# Files to compile and program file to run
COMPILEE_ARRAY=("Data.java" "utils/Sort.java" "Main.java")
PROGRAM="Main"

SCRIPT_DIR=$(dirname "$0")
cd "$SCRIPT_DIR"

# find 'src' directory
while [ "$(basename "$(pwd)")" != "src" ]; do
  cd ..
  if [ "$(pwd)" = "/" ]; then
    echo -e "\033[31mReached root directory, 'src' not found.\033[0m"
    exit 1
  fi
done

echo -e "\033[32mFound 'src' directory. Attempting clean, compile, and run...\033[0m"

unset SCRIPT_DIR

test_status() {
  local pass
  local fail

  while [ "$#" -gt 0 ]; do
    case "$1" in
      pass=*)
        pass="${1#pass=}"
        ;;
      fail=*)
        fail="${1#fail=}"
        ;;
    esac
    shift
  done

  if [ $? -eq 0 ]; then
    echo -e "\033[32m\u2022 ${pass}\033[0m"
  else
    echo -e "\033[31m\u2022 ${fail}\033[0m"
    exit 1
  fi
}

# pre-cleaning: remove existing .class files
find . -name "*.class" -exec rm -f {} +
test_status pass="Pre-cleaning process successful." fail="Pre-cleaning process failed."



# check all needed files are present
missing_files=()
for COMPILEE in "${COMPILEE_ARRAY[@]}"; do
  if [ ! -f "${COMPILEE}" ]; then
    echo -e "\033[31m\u2022 File not found: '${COMPILEE}'\033[0m"
    missing_files+=("${COMPILEE}")
  fi
done

# exit if any needed files are missing
if [ ${#missing_files[@]} -ne 0 ]; then
  echo -e "\033[31mThere are missing files. Exiting...\033[0m"
  exit 1
else
  echo -e "\033[32mAll compilees present.\033[0m"
fi

# compile needed files
for COMPILEE in "${COMPILEE_ARRAY[@]}"; do
  javac "${COMPILEE}"
  test_status pass="'${COMPILEE}' compiled successfully." fail="'${COMPILEE}' compilation failed."
done

printf "\n"

# run
java ${PROGRAM}
test_status pass="'${PROGRAM}' ran successfully." fail="Java program execution failed."

# post-cleaning: remove existing .class files
find . -name "*.class" -exec rm -f {} +
test_status pass="Post-cleaning process successful." fail="Post-cleaning process failed."
