pipeline {
  agent any
  tools {
    jdk 'JDK21'
    maven 'M3'
  }
  environment {
    COVERAGE_THRESHOLD = '70'
    PUBLISH_DIR        = 'C:\\ProgramData\\Jenkins\\.jenkins\\target'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Clean & Install') {
      steps {
        // Сборка и установка всех модулей для разрешения зависимостей
        bat 'mvn clean install -DskipTests'
      }
    }

    stage('Analyzator (PMD)') {
      when { branch 'develop' }
      steps {
        // Генерация полноценного отчёта с HTML
        bat 'mvn site -DskipTests'
      }
    }

    stage('Publish PMD Report') {
      when { branch 'develop' }
      steps {
        // Разрешаем отсутствие отчётов
        archiveArtifacts artifacts: '**/target/site/pmd.html', fingerprint: true, allowEmptyArchive: true
        // Generate reports first (important!)
        sh 'mvn pmd:pmd'

        // Publish module-specific reports
        publishHTML([
            reportName: 'Services PMD Report',
            reportDir: 'services/target/site',
            reportFiles: 'pmd.html',
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true
        ])
        publishHTML([
            reportName: 'Common PMD Report',
            reportDir: 'common/target/site',
            reportFiles: 'pmd.html',
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true
        ])
      }
    }

    stage('Run Tests') {
      when {
        branch pattern: '^feature/.+', comparator: 'REGEXP'
      }
      steps {
        bat 'mvn test'
      }
    }

    stage('Measure Code Test Coverage') {
      steps {
        // Прогоняем тесты, чтобы сгенерировать .exec
        bat "mvn test"

        // Генерируем агрегированный отчёт и проверяем порог
        dir('coverage') {
          bat "mvn verify -Dcoverage.threshold=${env.COVERAGE_THRESHOLD}"
        }

        // Публикация HTML-отчёта, если он сгенерирован
        publishHTML([
          reportName:           'Jacoco Coverage',
          reportDir:            'coverage/target/site/jacoco-aggregate',
          reportFiles:          'index.html',
          allowMissing:         true,
          alwaysLinkToLastBuild:true,
          keepAll:              true
        ])
      }
    }

    stage('Install & Package Artifact') {
      steps {
        bat 'mvn package -DskipTests'
        bat 'mvn install -DskipTests'
        bat "copy aggregator\\target\\*-jar-with-dependencies.jar %PUBLISH_DIR%\\"
        echo "Артефакт опубликован в: ${env.PUBLISH_DIR}"
      }
    }
  }

  post {
    success {

      recordCoverage(
        tools: [[
          parser: 'JACOCO',
          pattern: 'coverage/target/site/jacoco-aggregate/jacoco.xml'
        ]],
        sourceCodeRetention: 'LAST_BUILD',
        // если покрытия не найдено — не падаем
        failOnError: false,
        qualityGates: [[
          metric: 'LINE',
          threshold: env.COVERAGE_THRESHOLD.toInteger(),
          // если упадёт ниже порога — шаг пометит билд как UNSTABLE
          criticality: 'UNSTABLE'
        ]],
        // отображать результаты и тренды
        checksAnnotationScope: 'SKIP'
      )

      echo 'Сборка успешно завершена'
    }
    failure {
      echo 'Сборка завершилась с ошибкой'
    }
  }
}